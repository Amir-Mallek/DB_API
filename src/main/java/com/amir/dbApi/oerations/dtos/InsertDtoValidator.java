package com.amir.dbApi.oerations.dtos;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class InsertDtoValidator implements ConstraintValidator<ValidInsertDto, InsertDto> {

    @Override
    public void initialize(ValidInsertDto constraintAnnotation) {}

    @Override
    public boolean isValid(InsertDto insertDto, ConstraintValidatorContext constraintValidatorContext) {
        for (Map<String, Object> row : insertDto.getValues()) {
            for (String col : insertDto.getCols()) {
                if (!row.containsKey(col)) {
                    return false;
                }
            }
        }
        return true;
    }
}
