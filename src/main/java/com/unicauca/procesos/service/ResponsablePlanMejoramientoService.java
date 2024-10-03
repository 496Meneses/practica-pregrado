package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.ResponsablePlanMejoramientoDTO;

import java.util.List;

public interface ResponsablePlanMejoramientoService {
	ResponsablePlanMejoramientoDTO crear(ResponsablePlanMejoramientoDTO dto) ;
	ResponsablePlanMejoramientoDTO obtenerResponsablePlanMejoramientoPorIdProceso(Long idProceso);

}
