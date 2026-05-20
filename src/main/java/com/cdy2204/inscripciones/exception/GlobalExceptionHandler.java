package com.cdy2204.inscripciones.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(
            EntityNotFoundException ex,
            WebRequest request) {

        Map<String, Object> error = new HashMap<>();
        error.put("fecha", LocalDateTime.now());
        error.put("estado", HttpStatus.NOT_FOUND.value());
        error.put("error", "Recurso no encontrado");
        error.put("mensaje", ex.getMessage());
        error.put("ruta", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidaciones(
            MethodArgumentNotValidException ex,
            WebRequest request) {

        Map<String, Object> erroresValidacion = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                erroresValidacion.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> error = new HashMap<>();
        error.put("fecha", LocalDateTime.now());
        error.put("estado", HttpStatus.BAD_REQUEST.value());
        error.put("error", "Error de validación");
        error.put("mensajes", erroresValidacion);
        error.put("ruta", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarErrorGeneral(
            Exception ex,
            WebRequest request) {

        Map<String, Object> error = new HashMap<>();
        error.put("fecha", LocalDateTime.now());
        error.put("estado", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error", "Error interno del servidor");
        error.put("mensaje", ex.getMessage());
        error.put("ruta", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}