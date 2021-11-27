package com.bsuir.khviasko.hotel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Data
@EqualsAndHashCode
public class Reservation implements Serializable {
    public static final String RESERVATION_CLASS_NAME = "Reservation";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", columnDefinition = "TIMESTAMP")
    private LocalDate startDate;

    @Column(name = "end_date", columnDefinition = "TIMESTAMP")
    private LocalDate endDate;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private ReservationStatus reservationStatus;

    public String getData() {
        return "reservation ID: " + id.toString() + "\n" +
                "start date: " + startDate.toString() + "\n" +
                "end date: " + endDate.toString() + "\n" +
                "total price: " + totalPrice + "\n" +
                "user ID: " + user.getId().toString() + "\n" +
                "room ID: " + room.getId().toString() + "\n" +
                "reservation status: " + reservationStatus.getStatusValue() + "\n\n";
    }
}
