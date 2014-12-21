package com.davidmogar.alsa.domain.places;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private Long latitude;

    private Long longitude;

    private String imagePath;

    public static Builder getBuilder(String name) {
        return new Builder(name);
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

    public static class Builder {
        Place built;

        Builder(String name) {
            built = new Place();
            built.name = name;
        }

        public Builder latitude(Long latitude) {
            built.latitude = latitude;

            return this;
        }

        public Builder longitude(Long longitude) {
            built.longitude = longitude;

            return this;
        }

        public Builder imagePath(String imagePath) {
            built.imagePath = imagePath;

            return this;
        }

        public Place build() {
            return built;
        }

    }

}
