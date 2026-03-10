package com.airbnb.edu.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.edu.user_service.model.Room;
import com.airbnb.edu.user_service.repository.RoomRepository;
import com.airbnb.edu.user_service.service.RoomService;

import jakarta.validation.Valid;



@RestController // punto de acceso a internet
@RequestMapping("/api/rooms") // url del controlador
@CrossOrigin(origins="*")
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping // Atiende peticiones GET en la URL
    public List<Room> listar() {
        return roomService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Room obtenerUno(@PathVariable Long id) {
        return roomService.buscarPorId(id);
    }
    

    @PostMapping // Atiende peticiones POST en la URL
    public Room guardar(@Valid @RequestBody Room room) {
        return roomService.crear(room);
    }
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
    try {
        roomService.borrarHabitacion(id);
        return "Habitación con ID " + id + " borrada con éxito.";
    } catch (RuntimeException e) {
        return e.getMessage();
    }
}

    @PutMapping("/{id}")
    public Room editar(@PathVariable Long id, @RequestBody Room usuarioConCambios) {
        return roomService.actualizar(id, usuarioConCambios);
    }

    @GetMapping("/filtro")
    public List<Room> filtrarporprecio(@RequestParam Double precio) {
        return roomService.obtenerPrecioMenor(precio);
    }
    
}