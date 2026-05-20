package com.cdy2204.inscripciones.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del curso es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El instructor es obligatorio")
    @Column(nullable = false)
    private String instructor;

    @NotBlank(message = "La duración es obligatoria")
    @Column(nullable = false)
    private String duracion;

    @NotNull(message = "El costo es obligatorio")
    @Positive(message = "El costo debe ser mayor a cero")
    @Column(nullable = false)
    private Double costo;
}