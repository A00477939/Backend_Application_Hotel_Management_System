package com.example.HotelManagement.Guests.Entity;

import com.example.HotelManagement.User.Entity.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Guests")
public class Guests {

    @Id
    @Column(name = "guest_id")
    private String guestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

}
