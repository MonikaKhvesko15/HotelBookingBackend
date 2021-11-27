package com.bsuir.khviasko.hotel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "reservation_status")
@Data
@EqualsAndHashCode
public class ReservationStatus implements Serializable {
    public static final String RESERVATION_CLASS_NAME = "Reservation";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_value")
    private String statusValue;
}
