package com.crm.userservice.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailOrPhoneValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailOrPhoneRequired {
    String message() default "Потрібно вказати хоча б email або номер телефону";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
