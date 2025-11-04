package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @PreUpdate
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}