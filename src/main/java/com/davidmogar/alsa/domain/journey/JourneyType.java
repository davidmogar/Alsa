package com.davidmogar.alsa.domain.journey;

public enum JourneyType {
    ONE_WAY("One way"), RETURN("Return");

    private String description;

    private JourneyType(String description) {
        this.description = description;
    }

    public String getValue() {
        return name();
    }

    public void setValue(String value) {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
