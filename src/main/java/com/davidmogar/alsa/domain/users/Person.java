package com.davidmogar.alsa.domain.users;

import com.davidmogar.alsa.domain.auth.User;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @OneToOne
    @JoinColumn
    private User user;

}
