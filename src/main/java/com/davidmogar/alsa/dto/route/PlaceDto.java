package com.davidmogar.alsa.dto.route;

import com.davidmogar.alsa.domain.route.Place;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlaceDto {

    private Long id;

    @NotNull
    @Size(max = 254)
    private String name;

    @NotNull
    @Size(min = 100, max = 200)
    private String description;

    private Long latitude;

    private Long longitude;

    private Long visits;

    @Size(max = 255)
    private String imagePath;

    public PlaceDto() {
    }

    public PlaceDto(Place place) {
        id = place.getId();
        name = place.getName();
        description = place.getDescription();
        latitude = place.getLatitude();
        longitude = place.getLongitude();
        imagePath = place.getImagePath();
        visits = place.getVisits();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
