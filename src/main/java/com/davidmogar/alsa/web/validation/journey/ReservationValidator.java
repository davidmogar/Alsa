package com.davidmogar.alsa.web.validation.journey;

import com.davidmogar.alsa.dto.journey.ReservationDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class ReservationValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ReservationDto.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ReservationDto reservationDto = (ReservationDto) target;

        switch (reservationDto.getIdentificationType()) {
            case NIE:
            case NIF:
                if (!reservationDto.getIdentification().matches("((^[XYZ]\\d{7,8}|^\\d{8})[A-HJ-NP-TV-Z]$)")) {
                    errors.rejectValue("identification", "validation.identification.invalid");
                }
                break;
            case PASSPORT:
                if (!reservationDto.getIdentification().matches("^\\d{7}?$")) {
                    errors.rejectValue("identification", "validation.identification.invalid");
                }
                break;

        }
    }

}
