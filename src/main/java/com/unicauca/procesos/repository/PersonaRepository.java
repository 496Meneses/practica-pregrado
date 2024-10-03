package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
