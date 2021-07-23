package com.carRentalSystem.repository;

import com.carRentalSystem.entity.Booking;
import com.carRentalSystem.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public List<Booking> findByUserId(int userId);

    public List<Booking> findByCarLicenseNumber(String carLicenseNumber, LocalDateTime start, LocalDateTime end);
}
