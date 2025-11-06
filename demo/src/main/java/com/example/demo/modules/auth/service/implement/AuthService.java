package com.example.demo.modules.auth.service.implement;

import com.example.demo.entity.User;
import com.example.demo.modules.auth.dtos.LoginRequest;
import com.example.demo.modules.auth.dtos.LoginResponse;
import com.example.demo.modules.auth.service.interfaces.AuthInterface;
import com.example.demo.modules.users.dtos.UserRequestDto;
import com.example.demo.modules.users.dtos.UserResponseDto;
import com.example.demo.modules.users.repository.UserRepository;
import com.example.demo.security.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthInterface {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRoles());

        return new LoginResponse(token, user.getUsername());
    }

    @Override
    public UserResponseDto register(UserRequestDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .roles(dto.getRoles())
                .build();

        User saved = userRepository.save(user);

        return new UserResponseDto(saved.getId(), saved.getUsername(), saved.getEmail(), saved.getRoles());
    }
}
