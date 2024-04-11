package com.example.HotelManagement.Guests.Repository;

import com.example.HotelManagement.Guests.Entity.Guests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestsRepository extends JpaRepository<Guests, String> {
}
