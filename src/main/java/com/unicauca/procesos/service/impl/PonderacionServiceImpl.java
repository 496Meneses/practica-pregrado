package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Archivo;
import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.domain.Ponderacion;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import com.unicauca.procesos.mapper.ArchivoMapper;
import com.unicauca.procesos.mapper.FuenteInformacionMapper;
import com.unicauca.procesos.mapper.PonderacionMapper;
import com.unicauca.procesos.repository.ArchivoRepository;
import com.unicauca.procesos.repository.FuenteInformacionRepository;
import com.unicauca.procesos.repository.PonderacionRepository;
import com.unicauca.procesos.repository.ProcesoRepository;
import com.unicauca.procesos.service.FuenteInformacionService;
import com.unicauca.procesos.service.PonderacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PonderacionServiceImpl implements PonderacionService {

	@Autowired
	private PonderacionRepository ponderacionRepository;
	@Autowired
	private ProcesoRepository procesoRepository;
	@Override
	public PonderacionDTO crear(PonderacionDTO dto) {
		Ponderacion ponderacion;
		ponderacion = PonderacionMapper.mapearEntidad(dto);
		ponderacion = this.ponderacionRepository.save(ponderacion);
		if (null != ponderacion.getId()) {
			return PonderacionMapper.mapearDTO(ponderacion);
		}
		return null;
	}

	@Override
	public List<PonderacionDTO> listarPonderacionPorFactoresOCaracteristicas(Long idProceso, boolean factores, Long idFactor) {
		if (factores) {
			return this.ponderacionRepository.findByProcesoIdAndFactorIsNotNullAndCaracteristicaIsNull(idProceso).stream().map(PonderacionMapper::mapearDTO).collect(Collectors.toList());
		}
		if (idFactor != null) {
			return this.ponderacionRepository.findByProcesoIdAndCaracteristicaIsNotNullAndFactorId(idProceso, idFactor).stream().map(PonderacionMapper::mapearDTO).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public Boolean eliminarPonderacion(Long idPonderacion) {
		this.ponderacionRepository.deleteById(idPonderacion);
		return true;
	}

	@Override
	public List<PonderacionDTO> listarPonderacionPorIdProcesoCaracteristicaYIdDiferenteDeNullo(Long idProceso, Long idCaracteristica) {
		return this.ponderacionRepository.findByProcesoIdAndCaracteristicaIdAndAspectoIsNotNull(idProceso, idCaracteristica).stream().map(PonderacionMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public List<PonderacionDTO> crearLista(List<PonderacionDTO> ponderacion) {
		List<PonderacionDTO> resultado = new ArrayList<>();
		for (PonderacionDTO dto: ponderacion) {
			resultado.add(this.crear(dto));
		}
		return resultado;
	}

	@Override
	public PonderacionDTO obtenerPonderacionDeLaCaracteristica(Long idProceso, Long idCaracteristica) {
		return PonderacionMapper.mapearDTO(this.ponderacionRepository.findByProcesoIdAndCaracteristicaIdAndAspectoIsNull(idProceso, idCaracteristica));
	}

	@Override
	public PonderacionDTO obtenerPonderacionDelFactor(Long idProceso, Long idFactor) {
		return PonderacionMapper.mapearDTO(this.ponderacionRepository.findByProcesoIdAndFactorIdAndCaracteristicaIsNull(idProceso, idFactor));
	}
}
