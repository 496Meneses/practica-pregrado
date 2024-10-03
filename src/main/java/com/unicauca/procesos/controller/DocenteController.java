package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.docente.DocenteListaResponse;
import com.unicauca.procesos.dto.docente.DocenteRequest;
import com.unicauca.procesos.dto.docente.DocenteResponse;
import com.unicauca.procesos.service.DocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Docente Controller" , description = "Serviciones relacionados con el docente")
@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	@Autowired
	private DocenteService docenteService;

	@Operation(summary = "Crear docente")
	@PostMapping("/crear")
	private DocenteResponse crearDocente(final @RequestBody DocenteRequest docente) {
		return this.docenteService.crear(docente);
	}

	@PostMapping("listar/{pageNumber}/{pageSize}/{idPrograma}")
	private Page<DocenteListaResponse> listarDocentes(final @PathVariable int pageNumber, final @PathVariable int pageSize, final @PathVariable Long idPrograma) {
		return this.docenteService.listar(pageNumber, pageSize, idPrograma);
	}
	@PostMapping("eliminarDocente/{id}")
	private DocenteResponse eliminarDocente(final @PathVariable Long id) {
		return this.docenteService.eliminar(id);
	}

	@GetMapping("consultar/{id}")
	private DocenteResponse consultarDocente(final @PathVariable Long id) {
		return this.docenteService.buscarPorId(id);
	}
	@GetMapping("listarCatalogo/{idPrograma}")
	private List<DocenteListaResponse> listarDocentesCatalogo(final @PathVariable Long idPrograma) {
		return this.docenteService.listarDocentesCatalogo(idPrograma);
	}
}
