package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.dto.asignatura.AsignaturaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	Page<Asignatura> findByAsignaturaSemestreAndPlanEstudioId(AsignaturaSemestre asignaturaSemestre, Long planEstudioId, Pageable pageable);

	List<Asignatura> findByPlanEstudioId(Long idPlanEstudio);
}