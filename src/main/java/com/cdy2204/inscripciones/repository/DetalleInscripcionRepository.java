package com.cdy2204.inscripciones.repository;

import com.cdy2204.inscripciones.entity.DetalleInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleInscripcionRepository extends JpaRepository<DetalleInscripcion, Long> {
}