package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.catalogos.TipoFuente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatTipoFuenteRepository extends JpaRepository<TipoFuente, Long> {
}
