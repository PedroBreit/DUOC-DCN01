package com.cdy2204.inscripciones.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EstudianteRequestDTO {

    @NotBlank(message = "El nombre del estudiante es obligatorio")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;
}