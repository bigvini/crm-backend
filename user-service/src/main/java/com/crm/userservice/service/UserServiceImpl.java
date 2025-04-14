package com.crm.userservice.service;

import com.crm.userservice.dto.UserRequestDto;
import com.crm.userservice.dto.UserResponseDto;
import com.crm.userservice.entity.UserEntity;
import com.crm.userservice.mapper.UserMapper;
import com.crm.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        UserEntity entity = userMapper.toEntity(requestDto);
        entity.setActive(true); // За замовчуванням активний
        UserEntity saved = userRepository.save(entity);
        return userMapper.toDto(saved);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
