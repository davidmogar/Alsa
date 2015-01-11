package com.davidmogar.alsa.web.data;

import com.davidmogar.alsa.domain.bus.IdentificationType;

public class BookData {

    private String firstName;
    private String lastName;
    private String identification;

    private String cardHolderName;
    private String cardNumber;
    private int cardExpirationMonth;
    private int cardExpirationYear;
    private int cardCsv;

    private boolean travelingWithBike;
    private boolean travelingWithPet;
    private boolean insurance;

    private IdentificationType identificationType;

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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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

    public int getCardCsv() {
        return cardCsv;
    }

    public void setCardCsv(int cardCsv) {
        this.cardCsv = cardCsv;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
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

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

}
