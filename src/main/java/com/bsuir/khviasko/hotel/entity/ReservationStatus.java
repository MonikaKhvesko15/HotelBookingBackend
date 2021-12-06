package com.bsuir.khviasko.hotel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "reservation_status")
@Getter
@Setter
@EqualsAndHashCode
public class ReservationStatus implements Serializable {
    public static final String RESERVATION_CLASS_NAME = "Reservation";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_value")
    private String statusValue;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "reservationStatus", cascade = CascadeType.ALL)
    private transient List<Reservation> reservations;
}
