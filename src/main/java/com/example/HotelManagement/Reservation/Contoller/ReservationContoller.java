package com.example.HotelManagement.Reservation.Contoller;

import com.example.HotelManagement.Reservation.Request.ReservationRequest;
import com.example.HotelManagement.Reservation.Service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationContoller {

    private ReservationService reservationService;

    public ReservationContoller(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/hotel")
    public ResponseEntity<ReservationRequest> addUserWithAddress(@RequestBody ReservationRequest request) {
       // reservationService.createReservation(request);
      //  return ResponseEntity.ok("User and address added successfully");
        return ResponseEntity.ok(request);

    }
}
