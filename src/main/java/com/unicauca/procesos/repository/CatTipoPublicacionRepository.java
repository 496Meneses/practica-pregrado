package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.TipoPublicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatTipoPublicacionRepository extends JpaRepository<TipoPublicacion, Long> {
}
