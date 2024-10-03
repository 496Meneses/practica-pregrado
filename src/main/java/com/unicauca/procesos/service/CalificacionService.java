package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.CalificacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;

import java.util.List;

public interface CalificacionService {
	List<CalificacionDTO> crear(List<CalificacionDTO> dto);
	List<CalificacionDTO> listarCalificacion (Long idProceso);
}
