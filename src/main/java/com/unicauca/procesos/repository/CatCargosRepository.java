package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatCargosRepository extends JpaRepository<Cargo, Long> {
}
