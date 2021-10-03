package com.bsuir.khviasko.hotel.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
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

    @Column(name = "is_blocked", columnDefinition = "boolean default false", insertable = false)
    private boolean isBlocked;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}
