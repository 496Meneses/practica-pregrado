package com.unicauca.procesos.repository;


import com.unicauca.procesos.domain.catalogos.NivelFormacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatNivelFormacionRepository extends JpaRepository<NivelFormacion, Long> {
}
