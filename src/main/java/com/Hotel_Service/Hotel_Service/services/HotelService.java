package com.Hotel_Service.Hotel_Service.services;

import com.Hotel_Service.Hotel_Service.entities.Hotel;

import java.util.List;

public interface HotelService {

    // TODO create Hotel method
    Hotel create(Hotel hotel);

    // TODO getAllHotels method
    List<Hotel> getAllHotels();

    // TODO get Hotel by Id
    Hotel getHotel(String id);
}
