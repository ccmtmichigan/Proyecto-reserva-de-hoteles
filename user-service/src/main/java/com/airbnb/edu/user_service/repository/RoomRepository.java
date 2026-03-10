package com.airbnb.edu.user_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbnb.edu.user_service.model.Room;

@Repository //conexión con la bd generado por h2
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByPrecioLessThanEqual(Double precio);

}
    
