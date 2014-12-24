package com.davidmogar.alsa.dto.routes;

import com.davidmogar.alsa.domain.routes.Route;

public class RouteDto {

    private Long id;
    private Long distance;
    private String name;
    private String description;
    private Long originPlaceId;
    private Long destinationPlaceId;

    public RouteDto() {
    }

    public RouteDto(Route route) {
        id = route.getId();
        distance = route.getDistance();
        name = route.getName();
        description = route.getDescription();
        originPlaceId = route.getOrigin().getId();
        destinationPlaceId = route.getDestination().getId();
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

    public Long getOriginPlaceId() {
        return originPlaceId;
    }

    public void setOriginPlaceId(Long originPlaceId) {
        this.originPlaceId = originPlaceId;
    }

    public Long getDestinationPlaceId() {
        return destinationPlaceId;
    }

    public void setDestinationPlaceId(Long destinationPlaceId) {
        this.destinationPlaceId = destinationPlaceId;
    }

}
