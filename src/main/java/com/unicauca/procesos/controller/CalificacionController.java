package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.CalificacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import com.unicauca.procesos.service.CalificacionService;
import com.unicauca.procesos.service.PonderacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Calificacion Controller" , description = "Serviciones relacionados a las Calificaciones")
@RestController
@RequestMapping("/api/calificacion")
public class CalificacionController {
	@Autowired
	private CalificacionService calificacionService;

	@Operation(summary = "Crear ponderacion")
	@PostMapping("/crear")
	public List<CalificacionDTO> crearCalificaciones(final @RequestBody List<CalificacionDTO> calificacion) {
		return this.calificacionService.crear(calificacion);
	}
	@Operation(summary = "Listar todas las calificaciones por proceso")
	@GetMapping("/listar/{idProceso}")
	public List<CalificacionDTO> liscarCalificacionPorProceso(final @PathVariable Long idProceso) {
		return this.calificacionService.listarCalificacion(idProceso);
	}
}
