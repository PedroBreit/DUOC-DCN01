package com.cdy2204.inscripciones.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class InscripcionResponseDTO {

    private Long inscripcionId;
    private String estudiante;
    private String correo;
    private LocalDateTime fechaInscripcion;
    private List<DetalleInscripcionResponseDTO> cursos;
    private Double totalPagar;
}