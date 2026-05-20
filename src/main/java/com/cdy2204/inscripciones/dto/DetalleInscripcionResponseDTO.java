package com.cdy2204.inscripciones.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetalleInscripcionResponseDTO {

    private Long cursoId;
    private String nombreCurso;
    private String instructor;
    private Double costo;
}