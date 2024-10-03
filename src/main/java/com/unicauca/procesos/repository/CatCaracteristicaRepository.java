package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Caracteristica;
import com.unicauca.procesos.domain.catalogos.Factor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatCaracteristicaRepository extends JpaRepository<Caracteristica, Long> {
    List<Caracteristica> findByFactorId(Long factorId);
}