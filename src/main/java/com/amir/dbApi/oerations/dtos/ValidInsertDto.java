package com.amir.dbApi.oerations.dtos;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = InsertDtoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInsertDto {
    String message() default "Invalid columns in new values.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
