package com.airbnb.edu.user_service.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.edu.user_service.model.Room;
import com.airbnb.edu.user_service.repository.RoomRepository;

@Service // encargado de las habitaciones
public class RoomService {

    @Autowired // Conecta con la parte del repositorio
    private RoomRepository roomRepository;

    // ver todas las casas
    public List<Room> obtenerTodas() {
        return roomRepository.findAll();
    }
    //consulta de casa
    public Room buscarPorId(Long id) {
    return roomRepository.findById(id).orElse(null);
    }

    // creación casa nueva
    public Room crear(Room room) {
        return roomRepository.save(room);
    }
    //eliminacion de casa
    public void borrarHabitacion(Long id){
    if(roomRepository.existsById(id)){
    roomRepository.deleteById(id);
    }else{
        throw new RuntimeException("La habitación con el ID "+id+" No existe.");
    }
    }

    public Room actualizar(Long id, Room datosNuevos) {
    Room usuarioExistente = roomRepository.findById(id).orElse(null);
    if (usuarioExistente != null) {
        usuarioExistente.setNombre(datosNuevos.getNombre());
        usuarioExistente.setPrecio(datosNuevos.getPrecio());
        usuarioExistente.setDescripcion(datosNuevos.getDescripcion());
        
        return roomRepository.save(usuarioExistente);
    }
    return null;
}
    //filtrar por lista de precio
    public List<Room> obtenerPrecioMenor(Double precio){
        return roomRepository.findByPrecioLessThanEqual(precio);
    }
}