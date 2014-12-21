package com.davidmogar.alsa.web.validation.auth;

import com.davidmogar.alsa.dto.auth.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatedPassword", "validation.required.repeatedPassword");

        UserDto user = (UserDto) target;

        if (!user.getPassword().equals(user.getRepeatedPassword())) {
            errors.rejectValue("password", "validation.notMatch.user.password");
        }
    }

}
