package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Ponderacion;
import com.unicauca.procesos.dto.CalificacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import com.unicauca.procesos.mapper.CalificacionMapper;
import com.unicauca.procesos.mapper.PonderacionMapper;
import com.unicauca.procesos.repository.CalificacionRepository;
import com.unicauca.procesos.repository.PonderacionRepository;
import com.unicauca.procesos.service.CalificacionService;
import com.unicauca.procesos.service.PonderacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalificacionServiceImpl implements CalificacionService {

	@Autowired
	private CalificacionRepository calificacionRepository;

	@Override
	public List<CalificacionDTO> crear(List<CalificacionDTO> listaDto) {
		List<CalificacionDTO> resultado = new ArrayList<>();
		for (CalificacionDTO dto: listaDto) {
			resultado.add(CalificacionMapper.mapearDTO(this.calificacionRepository.save(CalificacionMapper.mapearEntidad(dto))));
		}
		return resultado;
	}

	@Override
	public List<CalificacionDTO> listarCalificacion(Long idProceso) {
		return this.calificacionRepository.findByProcesoId(idProceso).stream().map(CalificacionMapper::mapearDTO).collect(Collectors.toList());
	}
}
