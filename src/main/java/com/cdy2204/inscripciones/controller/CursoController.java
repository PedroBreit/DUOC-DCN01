package com.cdy2204.inscripciones.controller;

import com.cdy2204.inscripciones.dto.CursoRequestDTO;
import com.cdy2204.inscripciones.entity.Curso;
import com.cdy2204.inscripciones.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@Valid @RequestBody CursoRequestDTO dto) {
        Curso cursoCreado = cursoService.agregarCurso(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoCreado);
    }
}