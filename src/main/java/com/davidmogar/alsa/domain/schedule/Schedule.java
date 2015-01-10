package com.davidmogar.alsa.domain.schedule;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.route.Route;

import javax.persistence.*;
import java.util.Date;

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

    public Schedule() {

    }

    public Schedule(Bus bus, Route route, Date date) {
        this.bus = bus;
        this.route = route;
        this.date = date;
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

}
