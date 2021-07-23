package com.carRentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    private String carLicenseNumber;
    private String manufacturer;
    private String model;
    private double basePrice;
    private double pricePerHour;
    private double securityDeposit;
    private boolean isBooked;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;

}
