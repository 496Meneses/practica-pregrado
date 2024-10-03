package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesDTO;

import java.util.List;

public interface CronogramaActividadesService {
	CronogramaActividadesDTO crear (CronogramaActividadesDTO dto);
	List<CronogramaActividadesDTO> listarConogramaActividadesPorIdPrograma (Long idPrograma, Long idProceso);
	Boolean eliminarConogramaActividades(Long idCronograma);
	CronogramaActividadesDTO consultarCronogramaPorId(Long idCronograma);
}
