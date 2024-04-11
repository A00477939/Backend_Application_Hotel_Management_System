package com.example.HotelManagement.User.Repository;

import com.example.HotelManagement.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
