package com.davidmogar.alsa.domain.journey;

import com.davidmogar.alsa.domain.bus.IdentificationType;
import com.davidmogar.alsa.domain.schedule.Schedule;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String code = UUID.randomUUID().toString();

    @Column(nullable = false, length = 25)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    private String identification;
    private IdentificationType identificationType;

    @Column(nullable = false, length = 254)
    private String oneWaySeats;

    private String returnSeats;

    private String cardHoldersName;
    private String cardNumber;
    private int cardCsv;
    private int cardExpirationMonth;
    private int cardExpirationYear;

    private boolean insuranceRequested;
    private boolean travelingWithBike;
    private boolean travelingWithPet;

    private double totalPrice;

    @ManyToOne
    @JoinColumn
    private Schedule oneWaySchedule;

    @ManyToOne
    @JoinColumn
    private Schedule returnSchedule;

    public static Builder getBuilder(String firstName, Schedule schedule) {
        return new Builder(firstName, schedule);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getOneWaySeats() {
        return oneWaySeats;
    }

    public void setOneWaySeats(String oneWaySeats) {
        this.oneWaySeats = oneWaySeats;
    }

    public String getReturnSeats() {
        return returnSeats;
    }

    public void setReturnSeats(String returnSeats) {
        this.returnSeats = returnSeats;
    }

    public String getCardHoldersName() {
        return cardHoldersName;
    }

    public void setCardHoldersName(String cardHoldersName) {
        this.cardHoldersName = cardHoldersName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardCsv() {
        return cardCsv;
    }

    public void setCardCsv(int cardCsv) {
        this.cardCsv = cardCsv;
    }

    public int getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationMonth(int cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public int getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardExpirationYear(int cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }

    public boolean isInsuranceRequested() {
        return insuranceRequested;
    }

    public void setInsuranceRequested(boolean insuranceRequested) {
        this.insuranceRequested = insuranceRequested;
    }

    public boolean isTravelingWithBike() {
        return travelingWithBike;
    }

    public void setTravelingWithBike(boolean travelingWithBike) {
        this.travelingWithBike = travelingWithBike;
    }

    public boolean isTravelingWithPet() {
        return travelingWithPet;
    }

    public void setTravelingWithPet(boolean travelingWithPet) {
        this.travelingWithPet = travelingWithPet;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Schedule getOneWaySchedule() {
        return oneWaySchedule;
    }

    public void setOneWaySchedule(Schedule oneWaySchedule) {
        this.oneWaySchedule = oneWaySchedule;
    }

    public Schedule getReturnSchedule() {
        return returnSchedule;
    }

    public void setReturnSchedule(Schedule returnSchedule) {
        this.returnSchedule = returnSchedule;
    }

    public static class Builder {
        Reservation built;

        Builder(String firstName, Schedule schedule) {
            built = new Reservation();
            built.firstName = firstName;
            built.oneWaySchedule = schedule;
        }

        public Builder code(String code) {
            built.code = code;

            return this;
        }

        public Builder lastName(String lastName) {
            built.lastName = lastName;

            return this;
        }

        public Builder identification(String identification) {
            built.identification = identification;

            return this;
        }

        public Builder identificationType(IdentificationType identificationType) {
            built.identificationType = identificationType;

            return this;
        }

        public Builder oneWaySeats(String oneWaySeats) {
            built.oneWaySeats = oneWaySeats;

            return this;
        }

        public Builder returnSeats(String returnSeats) {
            built.returnSeats = returnSeats;

            return this;
        }

        public Builder cardHolderName(String cardHolderName) {
            built.cardHoldersName = cardHolderName;

            return this;
        }

        public Builder cardNumber(String cardNumber) {
            built.cardNumber = cardNumber;

            return this;
        }

        public Builder cardCsv(int cardCsv) {
            built.cardCsv = cardCsv;

            return this;
        }

        public Builder cardExpirationMonth(int expirationMonth) {
            built.cardExpirationMonth = expirationMonth;

            return this;
        }

        public Builder cardExpirationYear(int expirationYear) {
            built.cardExpirationYear = expirationYear;

            return this;
        }

        public Builder insurance(boolean insurance) {
            built.insuranceRequested = insurance;

            return this;
        }

        public Builder travelingWithBike(boolean travelingWithBike) {
            built.travelingWithBike = travelingWithBike;

            return this;
        }

        public Builder travelingWithPet(boolean travelingWithPet) {
            built.travelingWithPet = travelingWithPet;

            return this;
        }

        public Builder totalPrice(double totalPrice) {
            built.totalPrice = totalPrice;

            return this;
        }

        public Builder returnSchedule(Schedule returnSchedule) {
            built.returnSchedule = returnSchedule;

            return this;
        }

        public Reservation build() {
            return built;
        }
    }

}
