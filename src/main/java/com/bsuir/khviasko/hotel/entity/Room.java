package com.bsuir.khviasko.hotel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@EqualsAndHashCode
public class Room implements Serializable {
    public static final String ROOM_CLASS_NAME = "Room";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "room_type")
    private String roomType;

    private int capacity;

    private double price;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    private String description;

    @OneToOne(mappedBy="room")
    private Reservation reservation;
}
