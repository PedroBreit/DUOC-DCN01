package com.cdy2204.inscripciones.service;

import com.cdy2204.inscripciones.dto.CursoRequestDTO;
import com.cdy2204.inscripciones.entity.Curso;
import com.cdy2204.inscripciones.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso agregarCurso(CursoRequestDTO dto) {

        Curso curso = Curso.builder()
                .nombre(dto.getNombre())
                .instructor(dto.getInstructor())
                .duracion(dto.getDuracion())
                .costo(dto.getCosto())
                .build();

        return cursoRepository.save(curso);
    }
}