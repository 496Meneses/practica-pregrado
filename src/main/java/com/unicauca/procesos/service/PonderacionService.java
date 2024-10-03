package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;

import java.util.List;

public interface PonderacionService {
	PonderacionDTO crear(PonderacionDTO dto);
	List<PonderacionDTO> listarPonderacionPorFactoresOCaracteristicas (Long idProceso, boolean factores, Long idFactor);
	Boolean eliminarPonderacion(Long idPonderacion);

	List<PonderacionDTO> listarPonderacionPorIdProcesoCaracteristicaYIdDiferenteDeNullo(Long idProceso, Long idCaracteristica);

	List<PonderacionDTO> crearLista(List<PonderacionDTO> ponderacion);

	PonderacionDTO obtenerPonderacionDeLaCaracteristica(Long idProceso, Long idCaracteristica);

	PonderacionDTO obtenerPonderacionDelFactor(Long idProceso, Long idFactor);
}
