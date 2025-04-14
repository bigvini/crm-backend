package com.crm.userservice.service;

import com.crm.userservice.dto.UserRequestDto;
import com.crm.userservice.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto requestDto);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    void deleteUser(Long id);
}
