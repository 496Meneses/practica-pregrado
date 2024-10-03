package com.unicauca.procesos.service;

import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.dto.asignatura.AsignaturaDto;
import org.springframework.data.domain.Page;
import java.util.List;

public interface AsignaturaService {

	Page<AsignaturaDto> listar(AsignaturaDto asignaturaDto);
	Asignatura crearAsignatura(AsignaturaDto asignaturaDto);
	List<Asignatura> agregarAsignaturasANuevoPlanEstudio(PlanEstudio planEstudio, List<Asignatura> asignaturas);
	Boolean eliminarAsignatura(Long id);

	List<AsignaturaDto> listarAsignaturasDelPlanDeEstudios(Long idPlanEstudios);

}
