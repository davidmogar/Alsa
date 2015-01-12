package com.davidmogar.alsa.dto.route;

import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.route.Route;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RouteDto {

    private Long id;

    @NotNull
    private Long distance;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @NotEmpty
    @Size(min = 10, max = 254)
    private String description;

    private PlaceDto origin;
    private PlaceDto destination;

    /* Variables used to create objects from form */

    @NotEmpty
    private String originName;

    @NotEmpty
    private String destinationName;

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

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

}
