package com.davidmogar.alsa.domain.routes;

import com.davidmogar.alsa.domain.places.Place;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long distance;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    @JoinColumn
    private Place origin;

    @ManyToOne
    @JoinColumn
    private Place destination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Place getOrigin() {
        return origin;
    }

    public void setOrigin(Place origin) {
        this.origin = origin;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

}
