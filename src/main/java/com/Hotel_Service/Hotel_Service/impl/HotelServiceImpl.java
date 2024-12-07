package com.Hotel_Service.Hotel_Service.impl;

import com.Hotel_Service.Hotel_Service.entities.Hotel;
import com.Hotel_Service.Hotel_Service.exception.ResourceNotFoundException;
import com.Hotel_Service.Hotel_Service.repositories.HotelRepository;
import com.Hotel_Service.Hotel_Service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelid = UUID.randomUUID().toString();
        hotel.setId(hotelid);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
    }
}
