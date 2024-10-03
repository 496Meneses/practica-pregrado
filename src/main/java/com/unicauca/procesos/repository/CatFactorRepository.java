package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Factor;
import com.unicauca.procesos.domain.catalogos.TipoCalificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatFactorRepository extends JpaRepository<Factor, Long> {
}
