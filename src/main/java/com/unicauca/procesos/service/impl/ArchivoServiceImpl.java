package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.mapper.ArchivoMapper;
import com.unicauca.procesos.mapper.FuenteInformacionMapper;
import com.unicauca.procesos.repository.ArchivoRepository;
import com.unicauca.procesos.repository.FuenteInformacionRepository;
import com.unicauca.procesos.service.ArchivoService;
import com.unicauca.procesos.service.FuenteInformacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArchivoServiceImpl implements ArchivoService {

	@Autowired
	private ArchivoRepository archivoRepository;

	@Override
	public ArchivoDTO crear(ArchivoDTO dto) {
		return ArchivoMapper.mapearDTO(this.archivoRepository.save(ArchivoMapper.mapearEntidad(dto)));
	}

	@Override
	public List<ArchivoDTO> listarArchivosPorIdFuenteInformacion(Long idFuente) {
		return this.archivoRepository.findByFuenteInformacionId(idFuente).stream().map(ArchivoMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean eliminarArchivo(Long idArchivo) {
		this.archivoRepository.deleteById(idArchivo);
		return true;
	}
}
