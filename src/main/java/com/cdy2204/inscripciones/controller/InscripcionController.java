package com.cdy2204.inscripciones.controller;

import com.cdy2204.inscripciones.dto.InscripcionRequestDTO;
import com.cdy2204.inscripciones.dto.InscripcionResponseDTO;
import com.cdy2204.inscripciones.service.InscripcionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<InscripcionResponseDTO> registrarInscripcion(
            @Valid @RequestBody InscripcionRequestDTO dto) {

        InscripcionResponseDTO respuesta = inscripcionService.registrarInscripcion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}