package com.airbnb.edu.user_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.edu.user_service.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCorreo(String correo);
}