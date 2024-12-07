package com.Rating_Service.Rating_Service.impl;

import com.Rating_Service.Rating_Service.entities.Rating;
import com.Rating_Service.Rating_Service.repositories.RatingRespository;
import com.Rating_Service.Rating_Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRespository ratingRespository;
    @Override
    public Rating create(Rating rating) {
        String random = UUID.randomUUID().toString();
        rating.setRatingId(random);

        return ratingRespository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRespository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRespository.findByUserId(userId);

    }
    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRespository.findByHotelId(hotelId);


    }

}
