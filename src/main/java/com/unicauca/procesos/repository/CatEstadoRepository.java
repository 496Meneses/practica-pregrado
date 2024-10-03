package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Aspecto;
import com.unicauca.procesos.domain.catalogos.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatEstadoRepository extends JpaRepository<Estado, Long> {
    Estado findByDescripcion(String descripcion);
}