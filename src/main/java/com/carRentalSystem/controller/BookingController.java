package com.carRentalSystem.controller;

import com.carRentalSystem.entity.Car;
import com.carRentalSystem.entity.User;
import com.carRentalSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/user/booking")
    public List<Car> getAllBookedCarByUser(@RequestParam int userId, @RequestParam LocalDateTime start, @RequestParam LocalDateTime end){
        return bookingService.getAllBookedCarByUser(userId, start, end);
    }

    @GetMapping("/car/booking")
    public List<User> getAllUserBookedTheCar(@RequestParam String carLicenseNumber, @RequestParam LocalDateTime start, @RequestParam LocalDateTime end){
        return bookingService.getAllUserBookedTheCar(carLicenseNumber, start, end);
    }
}
