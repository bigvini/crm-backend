package com.crm.userservice.validation;

import com.crm.userservice.dto.UserRequestDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class EmailOrPhoneValidator implements ConstraintValidator<EmailOrPhoneRequired, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto dto, ConstraintValidatorContext context) {
        return StringUtils.hasText(dto.getEmail()) || StringUtils.hasText(dto.getPhone());
    }
}
