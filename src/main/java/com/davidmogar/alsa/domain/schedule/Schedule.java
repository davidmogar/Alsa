package com.davidmogar.alsa.domain.schedule;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.journey.Reservation;
import com.davidmogar.alsa.domain.route.Route;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    private Bus bus;

    @ManyToOne
    @JoinColumn
    private Route route;

    private Date date;

    @Column(nullable = false)
    private double hours;

    @Column(nullable = false)
    private double price;

    @OneToMany(mappedBy = "oneWaySchedule", cascade = CascadeType.ALL)
    private Set<Reservation> oneWayReservations;

    @OneToMany(mappedBy = "returnSchedule", cascade = CascadeType.ALL)
    private Set<Reservation> returnReservations;

    public Schedule() {

    }

    public Schedule(Bus bus, Route route, Date date, double hours, double price) {
        this.bus = bus;
        this.route = route;
        this.date = date;
        this.hours = hours;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Reservation> getOneWayReservations() {
        return oneWayReservations;
    }

    public void setOneWayReservations(Set<Reservation> oneWayReservations) {
        this.oneWayReservations = oneWayReservations;
    }

    public Set<Reservation> getReturnReservations() {
        return returnReservations;
    }

    public void setReturnReservations(Set<Reservation> returnReservations) {
        this.returnReservations = returnReservations;
    }

}
