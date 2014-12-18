package com.davidmogar.alsa.domain.users.customer;

import com.davidmogar.alsa.domain.users.Person;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends Person {

    @Column(nullable = false)
    private String address;

}
