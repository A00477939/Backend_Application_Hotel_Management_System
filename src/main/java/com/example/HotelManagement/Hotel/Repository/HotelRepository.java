package com.example.HotelManagement.Hotel.Repository;

import com.example.HotelManagement.Hotel.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
