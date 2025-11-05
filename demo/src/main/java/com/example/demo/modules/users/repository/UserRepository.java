package com.example.demo.modules.users.repository;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    java.util.Optional<User> findByUsername(String username);
    java.util.Optional<User> findByEmail(String email);
    java.util.Optional<User> findById(Long id);
}