package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.CronogramaActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Repository
@Service
public interface CronogramaActividadesRepository extends JpaRepository<CronogramaActividad, Long> {
	List<CronogramaActividad> findByProgramaId(Long idPrograma);

    List<CronogramaActividad> findByProgramaIdAndProcesoId(Long idPrograma, Long idProceso);
}
