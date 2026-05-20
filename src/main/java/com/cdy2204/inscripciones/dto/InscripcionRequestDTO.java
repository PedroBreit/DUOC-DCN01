package com.cdy2204.inscripciones.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class InscripcionRequestDTO {

    @Valid
    @NotNull(message = "Los datos del estudiante son obligatorios")
    private EstudianteRequestDTO estudiante;

    @NotEmpty(message = "Debe seleccionar al menos un curso")
    private List<Long> cursosIds;
}