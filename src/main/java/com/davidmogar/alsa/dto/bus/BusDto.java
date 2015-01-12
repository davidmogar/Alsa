package com.davidmogar.alsa.dto.bus;

import com.davidmogar.alsa.domain.bus.Bus;
import com.davidmogar.alsa.domain.bus.BusType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class BusDto {

    @NotEmpty
    @Size(min = 5, max = 10)
    private String licensePlate;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date lastRevision;

    @NotNull
    private BusType type;

    public BusDto() {

    }

    public BusDto(Bus bus) {
        licensePlate = bus.getLicensePlate();
        lastRevision = bus.getLastRevision();
        type = bus.getType();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Date getLastRevision() {
        return lastRevision;
    }

    public void setLastRevision(Date lastRevision) {
        this.lastRevision = lastRevision;
    }

    public BusType getType() {
        return type;
    }

    public void setType(BusType type) {
        this.type = type;
    }

}
