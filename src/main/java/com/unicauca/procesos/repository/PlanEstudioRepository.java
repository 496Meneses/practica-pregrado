package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.PlanEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Long> {
	PlanEstudio findByProcesoId(Long programaId);

	@Query("SELECT p FROM PlanEstudio p "
			+ "JOIN FETCH p.proceso pr "
			+ "JOIN FETCH pr.programa prg "
			+ "WHERE prg.id = :id "
			+ "ORDER BY p.fechaActualizacion DESC")
	List<PlanEstudio> buscarPlanEstudioMasRecientePorPrograma(@Param("id") Long id);

}
