package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Escalafon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatEscalafonRepository extends JpaRepository<Escalafon, Long> {
}
