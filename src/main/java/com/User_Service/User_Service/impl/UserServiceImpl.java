package com.User_Service.User_Service.impl;

import com.User_Service.User_Service.entities.Hotel;
import com.User_Service.User_Service.entities.Rating;
import com.User_Service.User_Service.entities.User;
import com.User_Service.User_Service.exception.ResourceNotFoundExp;
import com.User_Service.User_Service.repositories.UserRepository;
import com.User_Service.User_Service.services.UserServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();

//        List<User> users = userRepository.findAll();
//
//        for (User user : users) {
//            String url = "http://localhost:8083/ratings/users/" + user.getUserId();
//            List<Rating> ratings = restTemplate.getForObject(url, ArrayList.class);
//
//            logger.info("Fetched ratings for userId {}: {}", user.getUserId(), ratings);
//
//            user.setRatings(ratings);
//        }
//
//        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundExp("User with given Id not found: " + userId));

//        String url = "http://localhost:8083/ratings/users/" + user.getUserId();
        String url = "http://RATING-SERVICE/ratings/users/" + user.getUserId();
        Rating[] ratingsOfUser = restTemplate.getForObject(url, Rating[].class);
        logger.info("Fetched ratings for userId {}: {}", userId, Arrays.toString(ratingsOfUser));

        List<Rating> ratings = Arrays.asList(ratingsOfUser);

        List<Rating> ratingList = ratings.stream().map(rating -> {

//            String hotelUrl = "http://localhost:8082/hotels/" + rating.getHotelId();
            String hotelUrl = "http://HOTEL-SERVICE/hotels/" + rating.getHotelId();
            ResponseEntity<Hotel> response = restTemplate.getForEntity(hotelUrl, Hotel.class);
            Hotel hotel = response.getBody();

            logger.info("Fetching hotel details for hotelId: {}", rating.getHotelId());
            logger.info("Fetched hotel details: {}", hotel);

            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

}
