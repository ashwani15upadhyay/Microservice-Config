package com.Hotel_Service.Hotel_Service.repositories;

import com.Hotel_Service.Hotel_Service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
