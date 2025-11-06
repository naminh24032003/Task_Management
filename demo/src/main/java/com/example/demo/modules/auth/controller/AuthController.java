package com.example.demo.modules.auth.controller;


import com.example.demo.dtos.ApiResponseDTO;
import com.example.demo.modules.auth.dtos.LoginRequest;
import com.example.demo.modules.auth.dtos.LoginResponse;
import com.example.demo.modules.users.dtos.UserRequestDto;
import com.example.demo.modules.users.dtos.UserResponseDto;
import com.example.demo.modules.auth.service.implement.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO<LoginResponse>> login(@RequestBody LoginRequest request) {
        LoginResponse result = authService.login(request);

        ApiResponseDTO<LoginResponse> response = ApiResponseDTO.<LoginResponse>builder()
            .status(HttpStatus.OK.value())
            .message("Login successfully")
            .data(result)
            .build();

        return ResponseEntity.ok(response);
    }

    // ✅ REGISTER USER
    @PostMapping("/register")
    public ResponseEntity<ApiResponseDTO<UserResponseDto>> register(@RequestBody UserRequestDto dto) {
        UserResponseDto createdUser = authService.register(dto);

        ApiResponseDTO<UserResponseDto> response = ApiResponseDTO.<UserResponseDto>builder()
            .status(HttpStatus.CREATED.value())
            .message("Register successfully")
            .data(createdUser)
            .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
