package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.docente.DocenteListaResponse;
import com.unicauca.procesos.dto.docente.DocenteRequest;
import com.unicauca.procesos.dto.docente.DocenteResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DocenteService {
	DocenteResponse crear(DocenteRequest docenteRequest);
	Page<DocenteListaResponse> listar(final int pageNumber, final int pageSize, Long idPrograma);
	DocenteResponse eliminar(Long id);
	DocenteResponse editar(DocenteRequest docenteRequest);

	DocenteResponse buscarPorId(Long idDocente);

	List<DocenteListaResponse> listarDocentesCatalogo(Long idPrograma);
}
