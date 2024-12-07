package com.Rating_Service.Rating_Service.services;

import com.Rating_Service.Rating_Service.entities.Rating;

import java.util.List;

public interface RatingService {

    // TODO create rating
    Rating create(Rating rating);

    // TODO getALLRating
    List<Rating> getAllRatings();
//    Rating getRatingByRatingId (String ratingId);

    // TODO get all by HotelId
    List<Rating> getRatingByHotelId(String hotelId);

    // TODO get all by UserId
    List<Rating> getRatingByUserId(String userId);
}
