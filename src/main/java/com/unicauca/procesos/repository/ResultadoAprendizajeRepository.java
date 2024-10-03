package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.ResponsableAcreditacion;
import com.unicauca.procesos.domain.ResultadoAprendizaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface ResultadoAprendizajeRepository extends JpaRepository<ResultadoAprendizaje, Long> {
	List<ResultadoAprendizaje> findByProgramaIdAndDocenteIdIsNull(Long idPrograma);
	List<ResultadoAprendizaje> findByCatResultadoAprendizajeId(Long id);
	List<ResultadoAprendizaje> findByProgramaIdAndDocenteIdIsNotNull(Long idPrograma);

	List<ResultadoAprendizaje> findByProgramaIdAndProcesoIdAndDocenteIdIsNull(Long idPrograma, Long idProceso);
}
