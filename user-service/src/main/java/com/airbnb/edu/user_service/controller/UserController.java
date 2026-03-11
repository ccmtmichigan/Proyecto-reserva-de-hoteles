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
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listar() {
        return userService.listarTodos();
    }

    @GetMapping("/{id}")
    public User obtenerUno(@PathVariable Integer id) {
        return userService.buscarPorId(id);
    }

    @PostMapping
    public User guardar(@Valid @RequestBody User usuario) {
        return userService.crear(usuario);
    }

    @PutMapping("/{id}")
    public User editar(@PathVariable Integer id, @Valid @RequestBody User usuario) {
        return userService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        userService.eliminar(id);
        return "Usuario eliminado correctamente";
    }
}