package com.davidmogar.alsa.web.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    int minLength;
    boolean useAlphanumeric;
    boolean useSpecial;
    boolean useUppercase;

    @Override
    public void initialize(Password password) {
        minLength = password.minLength();
        useAlphanumeric = password.useAlphanumeric();
        useSpecial = password.useSpecial();
        useUppercase = password.useUppercase();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;

        if (password.length() < minLength) {
            valid = false;
        } else if (useUppercase && password.equals(password.toLowerCase())) {
            valid = false;
        } else if (useSpecial && password.matches("[A-Za-z0-9 ]*")) {
            valid = false;
        } else if (useAlphanumeric && !password.matches(".*\\d.*")) {
            valid = false;
        }

        return valid;
    }
}
