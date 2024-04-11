package com.example.HotelManagement.Reservation.Request;


import com.example.HotelManagement.Guests.Entity.Guests;
import com.example.HotelManagement.User.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class ReservationRequest {

    private User user;
    @JsonProperty("hotel_id")
    private String hotelId;
    @JsonProperty("check_in_date")
    private String checkInDate;
    @JsonProperty("check_out_date")
    private String checkOutDate;
    private List<Guests> guests;
}
