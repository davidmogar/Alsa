package com.davidmogar.alsa.web.data;

import org.hibernate.validator.constraints.NotEmpty;

public class JourneyData {

    @NotEmpty
    private String day;

    @NotEmpty
    private String destination;

    @NotEmpty
    private String hour;

    @NotEmpty
    private String origin;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
