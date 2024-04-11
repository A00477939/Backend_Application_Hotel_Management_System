package com.example.HotelManagement.Hotel.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Hotels")
public class Hotel {

    @Id
    @Column(name = "hotel_id")
    private String Id;
    @Column(name ="hotel_name")
    private String Name;
    @Column(name ="number_of_rooms")
    private String rooms;
    @Column(name ="price")
    private String price;
}
