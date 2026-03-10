package com.airbnb.edu.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airbnb.edu.user_service.model.User;
import com.airbnb.edu.user_service.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    // Conectamos el servicio con los datos alojados
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Se prepara la información para guardar
    public User guardar(User usuario) {
        return userRepository.save(usuario);
    }

    // Se en lista cada usuario
    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public User buscarPorId(Long id) {
    return userRepository.findById(id).orElse(null);
    }

    public void borrar(Long id){
    userRepository.deleteById(id);
    }
    
    public User actualizar(Long id, User datosNuevos) {
    User usuarioExistente = userRepository.findById(id).orElse(null);
    if (usuarioExistente != null) {
        usuarioExistente.setNombre(datosNuevos.getNombre());
        usuarioExistente.setEmail(datosNuevos.getEmail());
        
        return userRepository.save(usuarioExistente);
    }
    return null;
}
}
