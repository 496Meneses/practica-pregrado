package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.catalogos.TipoPublico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatTipoPublicoRepository extends JpaRepository<TipoPublico, Long> {
}
