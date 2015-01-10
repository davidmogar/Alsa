package com.davidmogar.alsa.dto.route;

import com.davidmogar.alsa.domain.route.Place;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlaceDto {

    private Long id;

    @NotNull
    @Size(max = 254)
    private String name;

    private Long latitude;

    private Long longitude;

    @Size(max = 255)
    private String imagePath;

    public PlaceDto() {

    }

    public PlaceDto(Place place) {
        id = place.getId();
        name = place.getName();
        latitude = place.getLatitude();
        longitude = place.getLongitude();
        imagePath = place.getImagePath();
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
