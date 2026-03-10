package com.airbnb.edu.user_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Este método "atrapa" el error de las validaciones (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> manejarErroresValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> listaErrores = new HashMap<>();

        // Recorremos los errores y guardamos: "campo" -> "mensaje"
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            listaErrores.put(error.getField(), error.getDefaultMessage());
        });

        return listaErrores;
    }
}