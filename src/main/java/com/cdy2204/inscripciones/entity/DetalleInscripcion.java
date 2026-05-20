package com.cdy2204.inscripciones.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleInscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double costoCurso;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id", nullable = false)
    private Inscripcion inscripcion;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}