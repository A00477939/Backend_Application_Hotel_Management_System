package com.example.HotelManagement.Hotel.Controller;

import com.example.HotelManagement.Hotel.Entity.Hotel;
import com.example.HotelManagement.Hotel.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel")
    public ResponseEntity<?> getAllHotels(){
        List<Hotel> hotels = hotelService.getAllHotels();
        if(hotels.isEmpty()) {
            String message = "No hotel found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return new ResponseEntity<>(hotels,HttpStatus.OK);
    }
}

