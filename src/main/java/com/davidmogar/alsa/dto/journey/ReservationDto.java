package com.davidmogar.alsa.dto.journey;

import com.davidmogar.alsa.domain.bus.IdentificationType;
import com.davidmogar.alsa.domain.journey.Reservation;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ReservationDto {

    private Long id;

    @NotEmpty
    @Size(max = 25)
    private String firstName;

    @NotEmpty
    @Size(max = 100)
    private String lastName;

    @NotEmpty
    private String code = UUID.randomUUID().toString();

    @NotEmpty
    private String identification;

    @NotNull
    private IdentificationType identificationType;

    private String oneWaySeats;
    private String returnSeats;

    @NotEmpty
    private String cardHoldersName;

    @NotEmpty
    private String cardNumber;
    private int cardCsv;

    @NotNull
    private int cardExpirationMonth;

    @NotNull
    private int cardExpirationYear;

    private boolean insuranceRequested;
    private boolean travelingWithBike;
    private boolean travelingWithPet;

    private double totalPrice;

    private ScheduleDto oneWayScheduleDto;
    private ScheduleDto returnScheduleDto;

    public ReservationDto() {
    }

    public ReservationDto(Reservation reservation) {
        id = reservation.getId();
        code = reservation.getCode();
        firstName = reservation.getFirstName();
        lastName = reservation.getLastName();
        identification = reservation.getIdentification();
        identificationType = reservation.getIdentificationType();
        oneWaySeats = reservation.getOneWaySeats();
        returnSeats = reservation.getReturnSeats();
        cardHoldersName = reservation.getCardHoldersName();
        cardNumber = reservation.getCardNumber();
        cardCsv = reservation.getCardCsv();
        cardExpirationMonth = reservation.getCardExpirationMonth();
        cardExpirationYear = reservation.getCardExpirationYear();
        insuranceRequested = reservation.isInsuranceRequested();
        travelingWithBike = reservation.isTravelingWithBike();
        travelingWithPet = reservation.isTravelingWithPet();
        totalPrice = reservation.getTotalPrice();

        Schedule oneWaySchedule = reservation.getOneWaySchedule();
        Schedule returnSchedule = reservation.getReturnSchedule();

        if (oneWaySchedule != null) {
            oneWayScheduleDto = new ScheduleDto(oneWaySchedule);
        }

        if (returnSchedule != null) {
            returnScheduleDto = new ScheduleDto(returnSchedule);
        }
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

    public ScheduleDto getOneWayScheduleDto() {
        return oneWayScheduleDto;
    }

    public void setOneWayScheduleDto(ScheduleDto oneWayScheduleDto) {
        this.oneWayScheduleDto = oneWayScheduleDto;
    }

    public ScheduleDto getReturnScheduleDto() {
        return returnScheduleDto;
    }

    public void setReturnScheduleDto(ScheduleDto returnScheduleDto) {
        this.returnScheduleDto = returnScheduleDto;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
