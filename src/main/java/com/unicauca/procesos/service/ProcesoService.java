package com.unicauca.procesos.service;

import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.dto.proceso.ProcesoDTO;

import java.util.List;

public interface ProcesoService {
	ProcesoDTO inicarProceso(ProcesoDTO proceso);
	ProcesoDTO consultarProceso(Long idProceso);
	ProcesoDTO consultarProcesoActivoPorIdPrograma(Long idPrograma);

	List<ProcesoDTO> listarProcesosDelPrograma(Long idPrograma);

	ProcesoDTO finalizarProceso(Long idProceso);

	ProcesoDTO guardarJustificacionPrograma(ProcesoDTO proceso);
}
