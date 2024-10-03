package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
