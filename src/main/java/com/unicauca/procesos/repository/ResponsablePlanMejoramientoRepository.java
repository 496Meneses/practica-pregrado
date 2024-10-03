package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Archivo;
import com.unicauca.procesos.domain.ResponsablePlanMejoramiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface ResponsablePlanMejoramientoRepository extends JpaRepository<ResponsablePlanMejoramiento, Long> {
	 ResponsablePlanMejoramiento findByProcesoId(Long idProceso);
}
