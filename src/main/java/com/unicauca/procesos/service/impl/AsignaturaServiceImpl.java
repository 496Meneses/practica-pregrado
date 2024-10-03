package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.dto.asignatura.AsignaturaDto;
import com.unicauca.procesos.mapper.AsignaturaMapper;
import com.unicauca.procesos.repository.AsignaturaRepository;
import com.unicauca.procesos.service.AsignaturaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;


	@Override
	public Page<AsignaturaDto> listar(AsignaturaDto asignaturaDto) {
		Page<Asignatura> page = this.asignaturaRepository.findByAsignaturaSemestreAndPlanEstudioId(asignaturaDto.getAsignaturaSemestre(), asignaturaDto.getIdPlanEstudio(), PageRequest.of(asignaturaDto.getPageNumber(), asignaturaDto.getPageSize()));
		return page.map(AsignaturaMapper::mappearAsignaturaDto);
	}

	@Override
	public Asignatura crearAsignatura(AsignaturaDto asignaturaDto) {
		return this.asignaturaRepository.save(AsignaturaMapper.mappearEntidad(asignaturaDto));
	}

	@Override
	public List<Asignatura> agregarAsignaturasANuevoPlanEstudio(PlanEstudio planEstudio, List<Asignatura> asignaturas) {
		asignaturas.forEach(asignatura -> {
			AsignaturaDto dto = AsignaturaMapper.mappearAsignaturaDto(asignatura);
			dto.setId(null);
			dto.setPlanEstudio(planEstudio);
			this.crearAsignatura(dto);
		});
		return asignaturas;
	}

	@Override
	public Boolean eliminarAsignatura(Long id) {
		this.asignaturaRepository.deleteById(id);
		return true;
	}

	@Override
	public List<AsignaturaDto> listarAsignaturasDelPlanDeEstudios(Long idPlanEstudio) {
		return this.asignaturaRepository.findByPlanEstudioId(idPlanEstudio).stream().map(AsignaturaMapper::mappearAsignaturaDto).collect(Collectors.toList());
	}
}
