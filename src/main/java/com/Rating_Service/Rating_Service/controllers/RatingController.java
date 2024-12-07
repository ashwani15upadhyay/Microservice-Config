package com.Rating_Service.Rating_Service.controllers;

import com.Rating_Service.Rating_Service.entities.Rating;
import com.Rating_Service.Rating_Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody  Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));

    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok((List<Rating>) ratingService.getRatingByUserId(userId));

    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable  String hotelId){
        return ResponseEntity.ok((List<Rating>) ratingService.getRatingByHotelId(hotelId));

    }
}
