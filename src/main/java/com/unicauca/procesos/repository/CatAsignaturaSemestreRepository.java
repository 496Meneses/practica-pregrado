package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatAsignaturaSemestreRepository extends JpaRepository<AsignaturaSemestre, Long> {
}
