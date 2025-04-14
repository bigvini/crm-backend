package com.crm.userservice.mapper;

import com.crm.userservice.dto.UserResponseDto;
import com.crm.userservice.dto.UserRequestDto;
import com.crm.userservice.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserRequestDto dto);

    UserResponseDto toDto(UserEntity entity);
}
