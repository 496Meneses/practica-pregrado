package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.catalogos.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface ProcesoRepository extends JpaRepository<Proceso, Long> {
	Proceso findByProgramaIdAndActivoTrue(Long programaId);
	List<Proceso> findByProgramaId(Long idPrograma);
	Proceso findByProgramaIdAndEstado(Long programaId, Estado estado);
}
