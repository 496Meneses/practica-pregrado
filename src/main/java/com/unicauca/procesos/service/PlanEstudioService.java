package com.unicauca.procesos.service;

import com.unicauca.procesos.domain.PlanEstudio;

public interface PlanEstudioService {
	PlanEstudio buscarPlanEstudioPorIdProceso(Long id);
	PlanEstudio crear(Long idProceso);
	PlanEstudio buscarPlanEstudioPorPrograma(Long id);

	void crearPlanEstudioConReciente(Long idPlanEstudioReciente, Long idProceso);
}
