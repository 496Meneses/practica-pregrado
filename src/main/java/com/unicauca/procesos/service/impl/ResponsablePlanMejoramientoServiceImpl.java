package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.ResponsablePlanMejoramientoDTO;
import com.unicauca.procesos.mapper.ArchivoMapper;
import com.unicauca.procesos.mapper.ResponsablePlanMejoramientoMapper;
import com.unicauca.procesos.repository.ArchivoRepository;
import com.unicauca.procesos.repository.ResponsablePlanMejoramientoRepository;
import com.unicauca.procesos.service.ArchivoService;
import com.unicauca.procesos.service.ResponsablePlanMejoramientoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResponsablePlanMejoramientoServiceImpl implements ResponsablePlanMejoramientoService {

	@Autowired
	private ResponsablePlanMejoramientoRepository responsablePlanMejoramientoRepository;

	@Override
	public ResponsablePlanMejoramientoDTO crear(ResponsablePlanMejoramientoDTO dto) {
		return ResponsablePlanMejoramientoMapper.mapearDTO(this.responsablePlanMejoramientoRepository.save(ResponsablePlanMejoramientoMapper.mapearEntidad(dto)));
	}

	@Override
	public ResponsablePlanMejoramientoDTO obtenerResponsablePlanMejoramientoPorIdProceso(Long idProceso) {
		return ResponsablePlanMejoramientoMapper.mapearDTO(this.responsablePlanMejoramientoRepository.findByProcesoId(idProceso));
	}
}
