package com.cdy2204.inscripciones.service;

import com.cdy2204.inscripciones.dto.*;
import com.cdy2204.inscripciones.entity.*;
import com.cdy2204.inscripciones.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionResponseDTO registrarInscripcion(InscripcionRequestDTO dto) {

        // Buscar estudiante por correo
        Estudiante estudiante = estudianteRepository
                .findByCorreo(dto.getEstudiante().getCorreo())
                .orElseGet(() -> {

                    Estudiante nuevo = Estudiante.builder()
                            .nombre(dto.getEstudiante().getNombre())
                            .correo(dto.getEstudiante().getCorreo())
                            .build();

                    return estudianteRepository.save(nuevo);
                });

        List<DetalleInscripcion> detalles = new ArrayList<>();

        double total = 0;

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setFechaInscripcion(LocalDateTime.now());
        inscripcion.setEstudiante(estudiante);

        for (Long cursoId : dto.getCursosIds()) {

            Curso curso = cursoRepository.findById(cursoId)
                    .orElseThrow(() ->
                            new EntityNotFoundException(
                                    "Curso no encontrado con ID: " + cursoId));

            DetalleInscripcion detalle = DetalleInscripcion.builder()
                    .curso(curso)
                    .costoCurso(curso.getCosto())
                    .inscripcion(inscripcion)
                    .build();

            detalles.add(detalle);

            total += curso.getCosto();
        }

        inscripcion.setDetalles(detalles);
        inscripcion.setTotalPagar(total);

        Inscripcion guardada = inscripcionRepository.save(inscripcion);

        List<DetalleInscripcionResponseDTO> cursosResponse =
                detalles.stream()
                        .map(detalle -> DetalleInscripcionResponseDTO.builder()
                                .cursoId(detalle.getCurso().getId())
                                .nombreCurso(detalle.getCurso().getNombre())
                                .instructor(detalle.getCurso().getInstructor())
                                .costo(detalle.getCostoCurso())
                                .build())
                        .toList();

        return InscripcionResponseDTO.builder()
                .inscripcionId(guardada.getId())
                .estudiante(estudiante.getNombre())
                .correo(estudiante.getCorreo())
                .fechaInscripcion(guardada.getFechaInscripcion())
                .cursos(cursosResponse)
                .totalPagar(total)
                .build();
    }
}