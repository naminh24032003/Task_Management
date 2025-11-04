package com.example.demo.modules.users.service.interfaces;

import com.example.demo.modules.users.dtos.UserRequestDto;
import com.example.demo.modules.users.dtos.UserResponseDto;

import java.util.List;

public interface UserInterface {
    List<UserResponseDto> getAllUsers();                 
    UserResponseDto createUser(UserRequestDto dto);      
    void deleteUser(Long userId);                       
}