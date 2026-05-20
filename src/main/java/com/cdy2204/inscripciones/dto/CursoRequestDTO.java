package com.cdy2204.inscripciones.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CursoRequestDTO {

    @NotBlank(message = "El nombre del curso es obligatorio")
    private String nombre;

    @NotBlank(message = "El instructor es obligatorio")
    private String instructor;

    @NotBlank(message = "La duración es obligatoria")
    private String duracion;

    @NotNull(message = "El costo es obligatorio")
    @Positive(message = "El costo debe ser mayor a cero")
    private Double costo;
}