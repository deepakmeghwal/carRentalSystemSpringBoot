package com.carRentalSystem.controller;

import com.carRentalSystem.entity.Car;
import com.carRentalSystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @GetMapping("/cars/{carLicenseNumber}")
    public Car getCar(@PathVariable String carLicenseNumber){
        return carService.getCar(carLicenseNumber);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getAllCar();
    }

    @PutMapping("/cars")
    public Car updateUser(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @DeleteMapping("/cars/{carLicenseNumber}")
    public void deleteUser(@PathVariable String carLicenseNumber){
        carService.deleteCar(carLicenseNumber);
    }

    @GetMapping("/search-cars")
    public List<Car> availableCarStartEndTime(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end){
        return carService.availableCarStartEndTime(start, end);
    }

    @GetMapping("/calculate-price")
    public double calculatePrice(@RequestParam String carLicenseNumber,  @RequestParam LocalDateTime start, @RequestParam LocalDateTime end){
        return carService.calculatePrice(carLicenseNumber, start, end);
    }
}
