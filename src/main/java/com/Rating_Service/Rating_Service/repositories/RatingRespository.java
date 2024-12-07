package com.Rating_Service.Rating_Service.repositories;

import com.Rating_Service.Rating_Service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRespository extends JpaRepository<Rating, String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
