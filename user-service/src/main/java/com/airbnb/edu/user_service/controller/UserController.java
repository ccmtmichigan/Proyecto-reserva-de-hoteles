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

import com.airbnb.edu.user_service.model.User;
import com.airbnb.edu.user_service.service.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")

public class UserController {

    private final UserService userService;

    // Conectamos controlador con user service
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Cuando se envian datos en POST
    @PostMapping
    public User crear(@Valid @RequestBody User usuario) {
        return userService.guardar(usuario);
    }

    // Cuando se piden los datos o obtener GET
    @GetMapping
    public List<User> listar() {
        return userService.listarTodos();
    }

    @GetMapping ("/{id}")
    public User obtenerUno(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }
    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable Long id){
        userService.borrar(id);
    }
    @PutMapping("/{id}")
    public User editar(@PathVariable Long id, @RequestBody User usuarioConCambios) {
        return userService.actualizar(id, usuarioConCambios);
    }
    
    
}
