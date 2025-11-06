package com.example.demo.modules.auth.service.interfaces;

import com.example.demo.modules.auth.dtos.LoginRequest;
import com.example.demo.modules.auth.dtos.LoginResponse;
import com.example.demo.modules.users.dtos.UserRequestDto;
import com.example.demo.modules.users.dtos.UserResponseDto;

public interface AuthInterface {
    LoginResponse login(LoginRequest request);
    UserResponseDto register(UserRequestDto dto);
}

