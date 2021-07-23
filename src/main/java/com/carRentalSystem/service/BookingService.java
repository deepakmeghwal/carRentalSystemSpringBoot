package com.carRentalSystem.service;

import com.carRentalSystem.entity.Booking;
import com.carRentalSystem.entity.Car;
import com.carRentalSystem.entity.User;
import com.carRentalSystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/car/book")
    public Booking bookCar(@RequestBody Booking booking){
        Car car = booking.getCar();
        car.setBooked(true);
        return  bookingRepository.save(booking);
    }

    public List<Car> getAllBookedCarByUser(int userId, LocalDateTime start, LocalDateTime end) {
        List<Booking>allBooking  = bookingRepository.findByUserId(userId);

        List<Car> allBookedCars = new ArrayList<>();
        for(Booking b : allBooking){
            Car currCar = b.getCar();
            //alll cars between booked start and end duration
            if(currCar.getBookingStart().compareTo(start) > 0 && currCar.getBookingStart().compareTo(end) < 0)
                allBookedCars.add(b.getCar());
        }

        return allBookedCars;
    }

    public List<User> getAllUserBookedTheCar(String carLicenseNumber, LocalDateTime start, LocalDateTime end) {
        List<Booking>allBooking  = bookingRepository.findByCarLicenseNumber(carLicenseNumber, start, end);

        List<User> allUserBookedCar = new ArrayList<>();
        for(Booking b : allBooking){
            allUserBookedCar.add(b.getUser());

        }

        return allUserBookedCar;

    }
}
