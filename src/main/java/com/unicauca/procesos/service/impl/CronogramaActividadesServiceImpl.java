package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesDTO;
import com.unicauca.procesos.mapper.ComiteMapper;
import com.unicauca.procesos.mapper.CronogramaActividadesMapper;
import com.unicauca.procesos.repository.ComiteRepository;
import com.unicauca.procesos.repository.CronogramaActividadesRepository;
import com.unicauca.procesos.service.CronogramaActividadesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CronogramaActividadesServiceImpl implements CronogramaActividadesService {

	@Autowired
	private CronogramaActividadesRepository cronogramaActividadesRepository;

	@Override
	public CronogramaActividadesDTO crear(CronogramaActividadesDTO dto) {
		return CronogramaActividadesMapper.mapearDTO(this.cronogramaActividadesRepository.save(CronogramaActividadesMapper.mapearEntidad(dto)));
	}

	@Override
	public List<CronogramaActividadesDTO> listarConogramaActividadesPorIdPrograma(Long idPrograma, Long idProceso) {
		return this.cronogramaActividadesRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso).stream().map(CronogramaActividadesMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean eliminarConogramaActividades(Long idCronograma) {
		this.cronogramaActividadesRepository.deleteById(idCronograma);
		return true;
	}

	@Override
	public CronogramaActividadesDTO consultarCronogramaPorId(Long idCronograma) {
		return CronogramaActividadesMapper.mapearDTO(this.cronogramaActividadesRepository.findById(idCronograma).isPresent() ? this.cronogramaActividadesRepository.findById(idCronograma).get() : null);
	}
}
