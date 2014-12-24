package com.davidmogar.alsa.domain.routes;

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

    public static Builder getBuilder(String name, Place origin, Place destination) {
        return new Builder(name, origin, destination);
    }

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

    public static class Builder {
        Route built;

        Builder(String name, Place origin, Place destination) {
            built = new Route();
            built.name = name;
            built.origin = origin;
            built.destination = destination;
        }

        public Builder distance(Long distance) {
            built.distance = distance;

            return this;
        }

        public Builder description(String description) {
            built.description = description;

            return this;
        }

        public Route build() {
            return built;
        }

    }

}
