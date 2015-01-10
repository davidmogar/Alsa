package com.davidmogar.alsa.dto.route;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;

public class RouteDto {

    private Long id;
    private Long distance;
    private String name;
    private String description;
    private PlaceDto origin;
    private PlaceDto destination;

    public RouteDto() {
    }

    public RouteDto(Route route) {
        id = route.getId();
        distance = route.getDistance();
        name = route.getName();
        description = route.getDescription();

        Place originPlace = route.getOrigin();
        if (originPlace != null) {
            origin = new PlaceDto(originPlace);
        }

        Place destinationPlace = route.getDestination();
        if (destinationPlace != null) {
            destination = new PlaceDto(destinationPlace);
        }
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

    public PlaceDto getOrigin() {
        return origin;
    }

    public void setOrigin(PlaceDto origin) {
        this.origin = origin;
    }

    public PlaceDto getDestination() {
        return destination;
    }

    public void setDestination(PlaceDto destination) {
        this.destination = destination;
    }

}
