package com.davidmogar.alsa.web.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    int minLength() default 8;

    boolean useAlphanumeric() default true;

    boolean useSpecial() default true;

    boolean useUppercase() default true;

    String message() default "Password is not secure enough";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
