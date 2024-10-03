package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.TipoDeVinculacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatTipoVinculacionRepository extends JpaRepository<TipoDeVinculacion, Long> {
}
