package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.catalogos.Estado;
import com.unicauca.procesos.dto.proceso.ProcesoDTO;
import com.unicauca.procesos.mapper.ProcesoMapper;
import com.unicauca.procesos.repository.CatEstadoRepository;
import com.unicauca.procesos.repository.PlanEstudioRepository;
import com.unicauca.procesos.repository.ProcesoRepository;
import com.unicauca.procesos.repository.ProgramaRepository;
import com.unicauca.procesos.service.PlanEstudioService;
import com.unicauca.procesos.service.ProcesoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProcesoServiceImpl implements ProcesoService {

	@Autowired
	private ProcesoRepository procesoRepository;
	@Autowired
	private ProgramaRepository programaRepository;
	@Autowired
	private PlanEstudioService planEstudioService;
	@Autowired
	private CatEstadoRepository catEstadoRepository;

	public static final String FINALIZADO = "FINALIZADO";
	public static final String PROCESO = "PROCESO";

	@Override
	public ProcesoDTO inicarProceso(final ProcesoDTO procesoDTO) {
		Estado estado = this.catEstadoRepository.findByDescripcion(PROCESO);
		if (this.procesoRepository.findByProgramaIdAndEstado(procesoDTO.getIdPrograma(), estado) != null) {
			return null;
		}
		Proceso proceso = new Proceso();
		proceso.setActivo(Boolean.TRUE);
		proceso.setEstado(this.catEstadoRepository.findByDescripcion(PROCESO));
		proceso.setPrograma(this.programaRepository.findById(procesoDTO.getIdPrograma()).get());
		proceso.setFechaInicio(LocalDate.now());
		proceso = this.procesoRepository.save(proceso);
		PlanEstudio planEstudio = null;
		if (procesoDTO.getId() != null) {
			planEstudio = planEstudioService.buscarPlanEstudioPorIdProceso(procesoDTO.getId());
		}
		if (planEstudio == null) {
			PlanEstudio planEstudioReciente = this.planEstudioService.buscarPlanEstudioPorPrograma(procesoDTO.getIdPrograma());
			if (planEstudioReciente == null) {
				this.planEstudioService.crear(proceso.getId());
			} else {
				this.planEstudioService.crearPlanEstudioConReciente(planEstudioReciente.getId(), proceso.getId());
			}
		}
		return ProcesoMapper.mapearDTO(proceso);
	}

	@Override
	public ProcesoDTO consultarProceso(final Long idProceso) {
		return ProcesoMapper.mapearDTO(this.procesoRepository.findById(idProceso).get());
	}

	@Override
	public ProcesoDTO consultarProcesoActivoPorIdPrograma(final Long idPrograma) {
		Estado estado = this.catEstadoRepository.findByDescripcion("PROCESO");
		Proceso proceso = this.procesoRepository.findByProgramaIdAndEstado(idPrograma, estado);
		if (null == proceso) {
			return null;
		}
		return ProcesoMapper.mapearDTO(proceso);
	}

	@Override
	public List<ProcesoDTO> listarProcesosDelPrograma(Long idPrograma) {
		List<Proceso> procesos = this.procesoRepository.findByProgramaId(idPrograma);
		return procesos.stream().map(ProcesoMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public ProcesoDTO finalizarProceso(Long idProceso) {
		Proceso proceso = this.procesoRepository.findById(idProceso).get();
		proceso.setEstado(this.catEstadoRepository.findByDescripcion(FINALIZADO));
		proceso.setFechaFinalizacion(LocalDate.now());
		return ProcesoMapper.mapearDTO(this.procesoRepository.save(proceso));
	}

	@Override
	public ProcesoDTO guardarJustificacionPrograma(ProcesoDTO dto) {
		Proceso proceso = this.procesoRepository.findById(dto.getId()).get();
		proceso.setJustificacionEvaluacion(dto.getJustificacionEvaluacion());
		return ProcesoMapper.mapearDTO(this.procesoRepository.save(proceso));
	}
}
