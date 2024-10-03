package com.unicauca.procesos.controller;

import com.unicauca.procesos.domain.catalogos.CatResultadoAprendizaje;
import com.unicauca.procesos.dto.CatResultadoAprendizajeDTO;
import com.unicauca.procesos.dto.CumplimientoRADTO;
import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.service.ResultadoAprendizajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Resultado Aprendizaje Controller" , description = "Serviciones relacionados al cumplimiento de los resultados de aprendizaje")
@RestController
@RequestMapping("/api/resultadoAprendizaje")
public class ResultadoAprendizajeController {
	@Autowired
	private ResultadoAprendizajeService resultadoAprendizajeService;

	@Operation(summary = "Crear cumplimiento resultado aprendizaje asignatura")
	@PostMapping("/crearCumplimiento/asignatura")
	public CumplimientoRADTO crearCumplimientoAsignatura(final @RequestBody CumplimientoRADTO dto) {
		return this.resultadoAprendizajeService.crearCumplimientoAsignatura(dto);
	}
	@Operation(summary = "Crear lista cumplimiento resultado aprendizaje asignatura")
	@PostMapping("/crearListaCumplimiento/asignatura")
	public List<CumplimientoRADTO> crearListaCumplimientoAsignatura(final @RequestBody List<CumplimientoRADTO> dtos) {
		return this.resultadoAprendizajeService.crearListaCumplimientoAsignatura(dtos);
	}
	@Operation(summary = "Crear lista cumplimiento resultado aprendizaje docente")
	@PostMapping("/crearListaCumplimiento/docente")
	public List<CumplimientoRADTO> crearListaCumplimientoDocente(final @RequestBody List<CumplimientoRADTO> dtos) {
		return this.resultadoAprendizajeService.crearListaCumplimientoDocente(dtos);
	}
	@Operation(summary = "Crear cumplimiento resultado aprendizaje docente")
	@PostMapping("/crearCumplimiento/docente")
	public CumplimientoRADTO crearCumplimientoDocente(final @RequestBody CumplimientoRADTO dto) {
		return this.resultadoAprendizajeService.crearCumplimientoDocente(dto);
	}
	@Operation(summary = "listar todos los cumplimientos de las asignaturas")
	@GetMapping("/obtenerCumplimientoAsignaturas/{idPrograma}/{idProceso}")
	public List<CumplimientoRADTO> listarCumplimientoAsignatura(final @PathVariable Long idPrograma, final @PathVariable Long idProceso) {
		return this.resultadoAprendizajeService.listarCumplimientoAsignatura(idPrograma, idProceso);
	}

	@Operation(summary = "listar todos los cumplimientos de los docentes")
	@GetMapping("/obtenerCumplimientoDocentes/{idPrograma}")
	public List<CumplimientoRADTO> listarCumplimientoDocente(final @PathVariable Long idPrograma) {
		return this.resultadoAprendizajeService.listarCumplimientoDocente(idPrograma);
	}
	@Operation(summary = "Crear catalogo resultado aprendizaje")
	@PostMapping("/crearCatResultadoAprendizaje")
	public CatResultadoAprendizajeDTO crearCatResultadoAprendizaje(final @RequestBody CatResultadoAprendizajeDTO dto) {
		return this.resultadoAprendizajeService.crearCatResultadoAprendizaje(dto);
	}
	@Operation(summary = "Crear lista catalogo resultado aprendizaje")
	@PostMapping("/crearListaCatResultadoAprendizaje")
	public List<CatResultadoAprendizajeDTO> crearCatResultadoAprendizaje(final @RequestBody List<CatResultadoAprendizajeDTO> dto) {
		return this.resultadoAprendizajeService.crearListaCatResultadoAprendizaje(dto);
	}
	@Operation(summary = "eliminar catalogo resultado aprendizaje")
	@PostMapping("/eliminarCat/{idCatResultadoAprendizaje}")
	public boolean eliminarCatResultadoAprendizaje(@PathVariable final Long idCatResultadoAprendizaje) {
		return this.resultadoAprendizajeService.eliminarCatResultadoAprendizaje(idCatResultadoAprendizaje);
	}
}
