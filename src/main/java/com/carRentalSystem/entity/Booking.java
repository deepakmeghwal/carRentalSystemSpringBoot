package com.carRentalSystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name ="Booking")
public class Booking {

    @Id
    private int bookingId;

    @ManyToOne
    private Car car;

    @ManyToOne
    private User user;
}
