package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.dto.ResponsableAcreditacionDTO;
import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.mapper.ComiteMapper;
import com.unicauca.procesos.mapper.ResponsableAcreditacionMapper;
import com.unicauca.procesos.repository.ComiteRepository;
import com.unicauca.procesos.repository.ResponsableAcreditacionRepository;
import com.unicauca.procesos.service.ComiteService;
import com.unicauca.procesos.service.ResponsableAcreditacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResponsableAcreditacionServiceImpl implements ResponsableAcreditacionService {

	@Autowired
	private ResponsableAcreditacionRepository responsableAcreditacionRepository;
	@Override
	public ResponsableAcreditacionDTO crear(ResponsableAcreditacionDTO dto) {
		return ResponsableAcreditacionMapper.mapearDTO(this.responsableAcreditacionRepository.save(ResponsableAcreditacionMapper.mapearEntidad(dto)));
	}

	@Override
	public List<ResponsableAcreditacionDTO> listarResponsableAcreditacionPorPrograma(Long idPrograma, Long idProceso) {
		return this.responsableAcreditacionRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso).stream().map(ResponsableAcreditacionMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean eliminarResponsable(Long idResponsable) {
		this.responsableAcreditacionRepository.deleteById(idResponsable);
		return true;
	}

	@Override
	public ResponsableAcreditacionDTO consultarResponsablePorIdResponsable(Long idResponsable) {
		return ResponsableAcreditacionMapper.mapearDTO(this.responsableAcreditacionRepository.findById(idResponsable).get());
	}
}
