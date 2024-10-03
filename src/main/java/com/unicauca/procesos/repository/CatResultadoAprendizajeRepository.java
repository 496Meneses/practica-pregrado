package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.catalogos.Aspecto;
import com.unicauca.procesos.domain.catalogos.CatResultadoAprendizaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CatResultadoAprendizajeRepository extends JpaRepository<CatResultadoAprendizaje, Long> {
    List<CatResultadoAprendizaje> findByProgramaIdAndProcesoId(Long idPrograma, Long idProceso);

    Optional<CatResultadoAprendizaje> findByCodigo(String codigo);
}