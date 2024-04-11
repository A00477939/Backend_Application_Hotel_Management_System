package com.example.HotelManagement.Reservation.Repository;

import com.example.HotelManagement.Reservation.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
