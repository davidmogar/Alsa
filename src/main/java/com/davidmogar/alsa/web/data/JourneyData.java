package com.davidmogar.alsa.web.data;

import com.davidmogar.alsa.domain.journey.JourneyType;
import org.hibernate.validator.constraints.NotEmpty;

public class JourneyData {

    @NotEmpty
    private String departureDate;

    private String returnDate;

    @NotEmpty
    private String destination;

    @NotEmpty
    private String origin;

    private JourneyType journeyType;

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public JourneyType getJourneyType() {
        return journeyType;
    }

    public void setJourneyType(JourneyType journeyType) {
        this.journeyType = journeyType;
    }

}
