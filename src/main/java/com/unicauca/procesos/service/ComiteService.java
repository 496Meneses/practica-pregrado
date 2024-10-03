package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.comite.ComiteDTO;

import java.util.List;

public interface ComiteService {
	ComiteDTO crear (ComiteDTO comiteDTO);
	List<ComiteDTO> listarComitePrograma (Long idPrograma, Long idProceso);
	Boolean eliminarComite(Long idComite);

	ComiteDTO consultarComitePorId(Long idComite);
}
