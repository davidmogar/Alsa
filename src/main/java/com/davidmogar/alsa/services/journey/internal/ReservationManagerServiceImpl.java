package com.davidmogar.alsa.services.journey.internal;


import com.davidmogar.alsa.domain.change.DatabaseChange;
import com.davidmogar.alsa.domain.journey.Reservation;
import com.davidmogar.alsa.domain.route.Place;
import com.davidmogar.alsa.domain.schedule.Schedule;
import com.davidmogar.alsa.dto.journey.ReservationDto;
import com.davidmogar.alsa.dto.schedule.ScheduleDto;
import com.davidmogar.alsa.persistence.change.DatabaseChangeDataService;
import com.davidmogar.alsa.persistence.journey.ReservationDataService;
import com.davidmogar.alsa.persistence.route.PlaceDataService;
import com.davidmogar.alsa.persistence.schedule.ScheduleDataService;
import com.davidmogar.alsa.services.journey.ReservationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationManagerServiceImpl implements ReservationManagerService {

    protected static final int NUMBER_OF_RESERVATION_PER_PAGE = 10;

    @Autowired
    private DatabaseChangeDataService databaseChangeDataService;

    @Autowired
    private PlaceDataService placeDataService;

    @Autowired
    private ReservationDataService reservationDataService;

    @Autowired
    private ScheduleDataService scheduleDataService;

    @Override
    public long count() {
        return reservationDataService.count();
    }

    @Override
    public void delete(long id) {
        reservationDataService.delete(id);
    }

    @Override
    public List<ReservationDto> findAll() {
        return StreamSupport.stream(reservationDataService.findAll().spliterator(), false)
                .map(ReservationDto::new).collect(Collectors.toList());
    }

    @Override
    public Page<ReservationDto> findAll(int pageIndex) {
        Pageable pageable = createPageable(pageIndex);
        Page<Reservation> page = reservationDataService.findAll(pageable);

        List<ReservationDto> users = page.getContent().stream().map(ReservationDto::new).collect(Collectors.toList());

        return new PageImpl<>(users, pageable, page.getTotalElements());
    }

    @Override
    public ReservationDto findByCode(String code) {
        ReservationDto reservationDto = null;
        Reservation reservation = reservationDataService.findByCode(code);

        if (reservation != null) {
            reservationDto = new ReservationDto(reservation);
        }

        return reservationDto;
    }

    @Override
    public ReservationDto findByCodeAndIndentification(String code, String identification) {
        ReservationDto reservationDto = null;
        Reservation reservation = reservationDataService.findByCodeAndIdentification(code, identification);

        if (reservation != null) {
            reservationDto = new ReservationDto(reservation);
        }

        return reservationDto;
    }

    @Override
    public List<ReservationDto> findByIndentification(String identification) {
        return StreamSupport.stream(reservationDataService.findByIdentification(identification).spliterator(), false)
                .map(ReservationDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ReservationDto> findByOneWayScheduleId(long id) {
        return StreamSupport.stream(reservationDataService.findByOneWayScheduleId(id).spliterator(), false)
                .map(ReservationDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ReservationDto> findByReturnScheduleId(long id) {
        return StreamSupport.stream(reservationDataService.findByReturnScheduleId(id).spliterator(), false)
                .map(ReservationDto::new).collect(Collectors.toList());
    }

    @Override
    public void save(ReservationDto reservationDto) {
        Schedule schedule = scheduleDataService.findOne(reservationDto.getOneWayScheduleDto().getId());

        if (schedule != null) {
            Reservation reservation = Reservation.getBuilder(reservationDto.getFirstName(), schedule)
                    .code(reservationDto.getCode())
                    .lastName(reservationDto.getLastName())
                    .identification(reservationDto.getIdentification())
                    .identificationType(reservationDto.getIdentificationType())
                    .oneWaySeats(reservationDto.getOneWaySeats())
                    .returnSeats(reservationDto.getReturnSeats())
                    .cardHolderName(reservationDto.getCardHoldersName())
                    .cardNumber(reservationDto.getCardNumber())
                    .cardCsv(reservationDto.getCardCsv())
                    .cardExpirationMonth(reservationDto.getCardExpirationMonth())
                    .cardExpirationYear(reservationDto.getCardExpirationYear())
                    .insurance(reservationDto.isInsuranceRequested())
                    .travelingWithBike(reservationDto.isTravelingWithBike())
                    .travelingWithPet(reservationDto.isTravelingWithPet())
                    .totalPrice(reservationDto.getTotalPrice())
                    .build();

            ScheduleDto returnScheduleDto = reservationDto.getReturnScheduleDto();

            if (returnScheduleDto != null) {
                schedule = scheduleDataService.findOne(reservationDto.getReturnScheduleDto().getId());

                if (schedule != null) {
                    reservation.setReturnSchedule(schedule);
                }
            }

            reservation = reservationDataService.save(reservation);

            /* Update place visits */
            Place place = reservation.getOneWaySchedule().getRoute().getOrigin();
            place.setVisits(place.getVisits() + 1);
            placeDataService.save(place);

            databaseChangeDataService.save(new DatabaseChange("Created reservation for name " +
                    reservationDto.getFirstName()));
        }
    }

    /**
     * Creates a new Pageable object. PageIndex should be a value starting at 1.
     *
     * @param pageIndex index of the desired page.
     * @return new Pageable object.
     */
    private Pageable createPageable(int pageIndex) {
        return new PageRequest(pageIndex - 1, NUMBER_OF_RESERVATION_PER_PAGE);
    }

}
