package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.repository.AsignaturaRepository;
import com.unicauca.procesos.repository.PlanEstudioRepository;
import com.unicauca.procesos.service.AsignaturaService;
import com.unicauca.procesos.service.PlanEstudioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PlanEstudioServiceImpl implements PlanEstudioService {
	private PlanEstudioRepository planEstudioRepository;
	private AsignaturaRepository asignaturaRepository;
	private AsignaturaService asignaturaService;

	@Override
	public PlanEstudio buscarPlanEstudioPorIdProceso(Long idProceso) {
		return planEstudioRepository.findByProcesoId(idProceso);
	}

	@Override
	public PlanEstudio crear(final Long idProceso) {
		PlanEstudio plan = new PlanEstudio();
		plan.setDescripcion("Plan");
		plan.setFechaActualizacion(LocalDate.now());
		Proceso proceso = new Proceso();
		proceso.setId(idProceso);
		plan.setProceso(proceso);
		return planEstudioRepository.save(plan);
	}

	@Override
	public PlanEstudio buscarPlanEstudioPorPrograma(Long id) {
		List<PlanEstudio> resultado = planEstudioRepository.buscarPlanEstudioMasRecientePorPrograma(id);
		if (resultado != null) {
			return planEstudioRepository.buscarPlanEstudioMasRecientePorPrograma(id).get(0);
		}
		return null;
	}

	@Override
	public void crearPlanEstudioConReciente(Long idPlanEstudioReciente, Long idProceso) {
		PlanEstudio nuevo = this.crear(idProceso);
		List<Asignatura> asignaturasPlanReciente = this.asignaturaRepository.findByPlanEstudioId(idPlanEstudioReciente);
		this.asignaturaService.agregarAsignaturasANuevoPlanEstudio(nuevo, asignaturasPlanReciente);
	}
}
