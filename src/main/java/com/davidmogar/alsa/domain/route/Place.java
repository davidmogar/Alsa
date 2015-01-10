package com.davidmogar.alsa.domain.route;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    private Long latitude;

    private Long longitude;

    private String imagePath;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.REMOVE)
    private Set<Route> destinationRoutes;

    @OneToMany(mappedBy = "origin", cascade = CascadeType.REMOVE)
    private Set<Route> originRoutes;

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

    public Set<Route> getDestinationRoutes() {
        return destinationRoutes;
    }

    public void setDestinationRoutes(Set<Route> destinationRoutes) {
        this.destinationRoutes = destinationRoutes;
    }

    public Set<Route> getOriginRoutes() {
        return originRoutes;
    }

    public void setOriginRoutes(Set<Route> originRoutes) {
        this.originRoutes = originRoutes;
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
