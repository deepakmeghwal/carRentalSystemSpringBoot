package com.carRentalSystem.service;

import com.carRentalSystem.entity.Car;
import com.carRentalSystem.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public double calculatePriceBasedOnParam(double priceRate, LocalDateTime start, LocalDateTime end){
        /// applied logic here
        int s = start.getHour();
        int e = end.getHour();
        double calculatedPrice = priceRate*(e-s);
        return calculatedPrice;
    }


    public Car saveCar(Car car){
        return  carRepository.save(car);
    }

    public Car getCar(String carLicenseNumber  ){
        return  carRepository.findById(carLicenseNumber).orElse(null);
    }

    public List<Car> getAllCar(){
        return  carRepository.findAll();
    }

    public void deleteCar(String carLicenseNumber){
        carRepository.deleteById(carLicenseNumber);
    }

    public Car updateCar(Car car){
        Car exitCar = carRepository.findById(car.getCarLicenseNumber()).orElse(null);
        if(exitCar != null){
            return carRepository.save(car);
        }
        return null;
    }

    public List<Car> availableCarStartEndTime(LocalDateTime starTime, LocalDateTime endTime){
        return carRepository.findByStartEndTime(starTime, endTime);
    }

    public double calculatePrice(String carLicenseNumber, LocalDateTime start, LocalDateTime end) {
        Car exitCar = carRepository.findById(carLicenseNumber).orElse(null);
        double priceRate = 0;
        if(exitCar != null){
            priceRate = exitCar.getPricePerHour();
        }

        return calculatePriceBasedOnParam(priceRate, start, end);
    }
}
