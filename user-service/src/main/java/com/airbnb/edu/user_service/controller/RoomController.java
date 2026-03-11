package com.airbnb.edu.user_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.edu.user_service.model.Room;
import com.airbnb.edu.user_service.service.RoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins="*")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) { this.roomService = roomService; }

    @GetMapping
    public List<Room> listar() { return roomService.obtenerTodas(); }

    @GetMapping("/{id}")
    public Room obtenerUno(@PathVariable Integer id) {
        return roomService.buscarPorId(id);
    }

    @PostMapping
    public Room guardar(@Valid @RequestBody Room room) { return roomService.crear(room); }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        roomService.borrarHabitacion(id);
        return "Borrado";
    }

    @PutMapping("/{id}")
    public Room editar(@PathVariable Integer id, @Valid @RequestBody Room datos) {
        return roomService.actualizar(id, datos);
    }
}