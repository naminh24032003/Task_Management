package com.example.demo.modules.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dtos.ApiResponseDTO;
import com.example.demo.modules.users.dtos.UserRequestDto;
import com.example.demo.modules.users.dtos.UserResponseDto;
import com.example.demo.modules.users.service.implement.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Lấy danh sách tất cả user
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<UserResponseDto>>> getAllUsers() {
        List<UserResponseDto> users = service.getAllUsers();
        ApiResponseDTO<List<UserResponseDto>> response = ApiResponseDTO.<List<UserResponseDto>>builder()
            .status(HttpStatus.OK.value())
            .message("Get all users successfully")
            .data(users)
            .build();
        return ResponseEntity.ok(response);
    }

    // Tạo user mới
    @PostMapping
    public ResponseEntity<ApiResponseDTO<UserResponseDto>> createUser(@RequestBody UserRequestDto dto) {
        UserResponseDto created = service.createUser(dto);
        ApiResponseDTO<UserResponseDto> response = ApiResponseDTO.<UserResponseDto>builder()
            .status(HttpStatus.CREATED.value())
            .message("User created successfully")
            .data(created)
            .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}