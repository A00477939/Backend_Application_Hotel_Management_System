package com.example.HotelManagement.Hotel.Service.Imp;

import com.example.HotelManagement.Hotel.Entity.Hotel;
import com.example.HotelManagement.Hotel.Repository.HotelRepository;
import com.example.HotelManagement.Hotel.Service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {
    private HotelRepository hotelRepository;

    public HotelServiceImp(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
