package com.carRentalSystem.repository;

import com.carRentalSystem.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    public List<Car> findByStartEndTime(LocalDateTime start, LocalDateTime end);
}
