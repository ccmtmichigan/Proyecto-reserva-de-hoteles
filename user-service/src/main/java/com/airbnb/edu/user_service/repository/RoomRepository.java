package com.airbnb.edu.user_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.edu.user_service.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByPrecioLessThan(Double precio);
}