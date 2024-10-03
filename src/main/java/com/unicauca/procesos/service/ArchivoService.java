package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.ArchivoDTO;

import java.util.List;

public interface ArchivoService {
	ArchivoDTO crear(ArchivoDTO dto);
	List<ArchivoDTO> listarArchivosPorIdFuenteInformacion (Long idFuenteInformacion);
	Boolean eliminarArchivo(Long idArchivo);
}
