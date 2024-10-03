package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Aspecto;
import com.unicauca.procesos.domain.catalogos.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatAspectoRepository extends JpaRepository<Aspecto, Long> {
    List<Aspecto> findByCaracteristicaId(Long caracteristicaId);
}