package com.davidmogar.alsa.domain.bus;

import com.davidmogar.alsa.domain.schedule.Schedule;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Bus {

    @Id
    @Column(nullable = false, length = 10)
    private String licensePlate;

    private Date lastRevision;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BusType type;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private Set<Schedule> schedules;

    public Bus() {
    }

    public Bus(String licensePlate, Date lastRevision, BusType type) {
        this.licensePlate = licensePlate;
        this.lastRevision = lastRevision;
        this.type = type;
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

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

}
