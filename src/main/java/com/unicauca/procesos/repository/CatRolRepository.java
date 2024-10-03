package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRolRepository extends JpaRepository<Rol, Long> {
}
