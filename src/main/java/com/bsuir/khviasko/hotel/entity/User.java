package com.bsuir.khviasko.hotel.entity;

import lombok.Data;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {
    public static final String USER_CLASS_NAME = "User";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String firstname;

    private String surname;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn (name="role_id")
    private Role role;

    @OneToOne(mappedBy = "user")
    private transient Reservation reservation;

}
