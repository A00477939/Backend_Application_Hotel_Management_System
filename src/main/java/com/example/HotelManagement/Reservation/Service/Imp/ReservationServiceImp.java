package com.example.HotelManagement.Reservation.Service.Imp;

import com.example.HotelManagement.Guests.Entity.Guests;
import com.example.HotelManagement.Guests.Repository.GuestsRepository;
import com.example.HotelManagement.Hotel.Repository.HotelRepository;
import com.example.HotelManagement.Reservation.Entity.Reservation;
import com.example.HotelManagement.Reservation.Repository.ReservationRepository;
import com.example.HotelManagement.Reservation.Request.ReservationRequest;
import com.example.HotelManagement.Reservation.Service.ReservationService;
import com.example.HotelManagement.User.Entity.User;
import com.example.HotelManagement.User.Repository.UserRepository;
import jakarta.servlet.Registration;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImp implements ReservationService {
    private final UserRepository userRepository;
    private final GuestsRepository guestsRepository;
    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;


    public ReservationServiceImp(UserRepository userRepository, GuestsRepository guestsRepository, ReservationRepository reservationRepository, HotelRepository hotelRepository) {
        this.userRepository = userRepository;
        this.guestsRepository = guestsRepository;
        this.reservationRepository = reservationRepository;
        this.hotelRepository = hotelRepository;
    }

    //Main Logic
    @Override
    public String createReservation(ReservationRequest reservationRequest) {
        String userName = reservationRequest.getUser().getName();
        String HotelId = reservationRequest.getHotelId();
        String CheckIn = reservationRequest.getCheckInDate();
        String CheckOut = reservationRequest.getCheckOutDate();
        String UserId = userCreation(userName);
        List<Guests> guest = reservationRequest.getGuests();
        guestsCreation(UserId, guest);
        Reservation newReservation = new Reservation();
        newReservation.setUser(userRepository.getReferenceById(UserId));
        newReservation.setHotel(hotelRepository.getReferenceById(HotelId));
        String reservationId = RegistrationId();
        newReservation.setReservationId(reservationId);
        newReservation.setCheckInDate(convertStringToDate(CheckIn));
        newReservation.setCheckOutDate(convertStringToDate(CheckOut));
        reservationRepository.save(newReservation);
        return reservationId;
    }



    //Registration Logic
    //Id
    public String RegistrationId() {
        // Retrieve the total count of hotels from the repository
        int totalRow = (int) reservationRepository.count();
        // Generate the ID based on the total count

        return "R" + (totalRow + 1) + "SMU";
    }

    //Guest Logic
    //Id
    public String GuestId() {
        // Retrieve the total count of hotels from the repository
        int totalGuest = (int) guestsRepository.count();
        // Generate the ID based on the total count
        return "G" + (totalGuest + 1);
    }
    private void guestsCreation(String userId, List<Guests> guest) {
        Guests person = new Guests();

        guest.stream()
                .forEach(newGuests -> {
                    String guestId = GuestId(); // You need to implement this method
                    String guestName = newGuests.getName();
                    String guestGender = newGuests.getGender();
                    person.setGuestId(guestId);
                    person.setUser(userRepository.getReferenceById(userId));
                    person.setName(guestName);
                    person.setGender(guestGender);
                    guestsRepository.save(person);

                });
    }

    //User Logic
    //Id
    public String generatUserId() {
        // Retrieve the total count of hotels from the repository
        int totalUser = (int) userRepository.count();
        // Generate the ID based on the total count

        return "U" + (totalUser + 1);
    }

    public String userCreation(String name){
        String id = generatUserId();
        User user = new User();
        user.setName(name);
        user.setId(id);
        userRepository.save(user);

        return id;
    }

    public static Date convertStringToDate(String dateString) {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            Date date = sdf.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
