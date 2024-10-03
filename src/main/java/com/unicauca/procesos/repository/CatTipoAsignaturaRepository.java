package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.TipoAsignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatTipoAsignaturaRepository extends JpaRepository<TipoAsignatura, Long> {
}
