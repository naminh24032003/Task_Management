package com.example.demo.modules.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "Email not valid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    // ✅ NEW: danh sách role
    private Set<String> roles;
}
