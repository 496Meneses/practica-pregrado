package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.programa.ListarProgramaResponse;
import com.unicauca.procesos.dto.programa.ProgramaRequest;
import com.unicauca.procesos.dto.programa.ProgramaResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramaService {

	Page<ListarProgramaResponse> listar(int pageNumber, int pageSize);
	Integer numeroProgramas();
	ResponseEntity<Object> crearPrograma(ProgramaRequest programa);
	ResponseEntity<Object> buscarPorId(Long id);
	ResponseEntity<Object> eliminarPrograma(Long id);

	List<ProgramaResponse> listarProgramasCatalogo();
}
