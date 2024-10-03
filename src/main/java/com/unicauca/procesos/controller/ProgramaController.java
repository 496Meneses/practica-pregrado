package com.unicauca.procesos.controller;

import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.dto.programa.ListarProgramaResponse;
import com.unicauca.procesos.dto.programa.ProgramaResponse;
import com.unicauca.procesos.service.PlanEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.unicauca.procesos.dto.programa.ProgramaRequest;
import com.unicauca.procesos.service.ProgramaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Programa Controller" , description = "Serviciones relacionados con el programa")
@RestController
@RequestMapping("/api/programa")
public class ProgramaController {
	
	@Autowired
	private ProgramaService programaService;
	@Autowired
	private PlanEstudioService planEstudioService;

    @Operation(summary = "Contar los programas")
    @GetMapping("/contar")
    public Integer contarProgramas() {
    	return programaService.numeroProgramas();
    }

	@Operation(summary = "Crear programa")
    @PostMapping("/crear")
    public ResponseEntity<Object> crearPrograma(@RequestBody ProgramaRequest programa) {
		return programaService.crearPrograma(programa);
    }

	@Operation(summary = "Obtener programa por ID")
	@GetMapping("/buscarPorId/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		return programaService.buscarPorId(id);
	}

	@Operation(summary = "Listar programas con paginacion sin filtros")
	@PostMapping("/listar/{pageSize}/{pageNumber}")
	public Page<ListarProgramaResponse> listarPrograma(@PathVariable int pageSize, @PathVariable int pageNumber) {
		return programaService.listar(pageSize, pageNumber);
	}

	@PostMapping("/eliminarProgramaPorId/{id}")
	public ResponseEntity<Object> eliminarPrograma(@PathVariable Long id) {
		return this.programaService.eliminarPrograma(id);
	}
	@Operation(summary = "Obtener plan estudio por ID")
	@GetMapping("/buscarPlanEstudio/{idProceso}")
	public PlanEstudio buscarPlanEstudio(@PathVariable Long idProceso) {
		return planEstudioService.buscarPlanEstudioPorIdProceso(idProceso);
	}
	@Operation(summary = "Listar Programas como catalogo")
	@GetMapping("/listarProgramasCatalogo")
	public List<ProgramaResponse> listarProgramasCatalogo() {
		return programaService.listarProgramasCatalogo();
	}
}
