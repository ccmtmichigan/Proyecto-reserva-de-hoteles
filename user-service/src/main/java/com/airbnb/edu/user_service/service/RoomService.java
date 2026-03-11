package com.airbnb.edu.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airbnb.edu.user_service.model.Room;
import com.airbnb.edu.user_service.repository.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> obtenerTodas() { return roomRepository.findAll(); }

    public Room buscarPorId(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room crear(Room room) { return roomRepository.save(room); }

    public void borrarHabitacion(Integer id) {
        roomRepository.deleteById(id);
    }

    public Room actualizar(Integer id, Room datos) {
        Room ex = roomRepository.findById(id).orElse(null);
        if (ex != null) {
            ex.setTitulo(datos.getTitulo());
            ex.setDescripcion(datos.getDescripcion());
            ex.setUbicacion(datos.getUbicacion());
            ex.setPrecio(datos.getPrecio());
            ex.setPuntuacion(datos.getPuntuacion());
            ex.setImagenUrl(datos.getImagenUrl());
            return roomRepository.save(ex);
        }
        return null;
    }

    public List<Room> obtenerPrecioMenor(Double p) { return roomRepository.findByPrecioLessThan(p); }
}