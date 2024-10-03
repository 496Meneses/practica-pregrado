package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;

import java.util.List;

public interface FuenteInformacionService {
	FuenteInformacionDTO crear(FuenteInformacionDTO dto);
	List<FuenteInformacionDTO> listarFuentesDocumentales (Long idProceso, boolean documental);
	Boolean eliminarFuenteInformacion(Long idFuente);
	FuenteInformacionDTO consultarFuenteInformacionPorId(Long idFuente);
	Boolean eliminarArchivoPorId(Long idArchivo);
}
