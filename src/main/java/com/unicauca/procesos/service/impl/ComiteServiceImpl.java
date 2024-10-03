package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.mapper.ComiteMapper;
import com.unicauca.procesos.repository.ComiteRepository;
import com.unicauca.procesos.service.ComiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComiteServiceImpl implements ComiteService {

	@Autowired
	private ComiteRepository comiteRepository;
	@Override
	public ComiteDTO crear(ComiteDTO comiteDTO) {
		return ComiteMapper.mapearDTO(this.comiteRepository.save(ComiteMapper.mapearEntidad(comiteDTO)));
	}

	@Override
	public List<ComiteDTO> listarComitePrograma(Long idPrograma, Long idProceso) {
		return this.comiteRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso).stream().map(ComiteMapper::mapearDTO).collect(Collectors.toList());
	}
	@Override
	public Boolean eliminarComite(Long idComite) {
		this.comiteRepository.deleteById(idComite);
		return true;
	}

	@Override
	public ComiteDTO consultarComitePorId(Long idComite) {
		return ComiteMapper.mapearDTO(this.comiteRepository.findById(idComite).isPresent() ? this.comiteRepository.findById(idComite).get():null);
	}
}
