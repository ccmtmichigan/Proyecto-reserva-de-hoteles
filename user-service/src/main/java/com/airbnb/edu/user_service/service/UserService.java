package com.airbnb.edu.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airbnb.edu.user_service.model.User;
import com.airbnb.edu.user_service.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listarTodos() {
        return userRepository.findAll();
    }

    public User buscarPorId(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User crear(User usuario) {
        return userRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        userRepository.deleteById(id);
    }

    public User actualizar(Integer id, User datos) {
        User userEx = userRepository.findById(id).orElse(null);
        if (userEx != null) {
            userEx.setNombre(datos.getNombre());
            userEx.setApellido(datos.getApellido());
            userEx.setCorreo(datos.getCorreo());
            userEx.setContrasena(datos.getContrasena());
            userEx.setRol(datos.getRol());
            userEx.setEstado(datos.getEstado());
            return userRepository.save(userEx);
        }
        return null;
    }
}