package com.example.demo.modules.users.service.implement;

import com.example.demo.entity.User;
import com.example.demo.modules.users.dtos.UserRequestDto;
import com.example.demo.modules.users.dtos.UserResponseDto;
import com.example.demo.modules.users.repository.UserRepository;
import com.example.demo.modules.users.service.interfaces.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserInterface {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return repo.findAll()
                .stream()
                .map(user -> new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getRoles()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); 
        User saved = repo.save(user);
        return new UserResponseDto(saved.getId(), saved.getUsername(), saved.getEmail(), saved.getRoles());
    }

    @Override
    public void deleteUser(Long userId) {
        repo.deleteById(userId);
    }
}
