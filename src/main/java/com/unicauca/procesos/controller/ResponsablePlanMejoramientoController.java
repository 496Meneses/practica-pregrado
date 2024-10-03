package com.unicauca.procesos.controller;

import com.unicauca.procesos.domain.ResponsablePlanMejoramiento;
import com.unicauca.procesos.dto.ResponsablePlanMejoramientoDTO;
import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.service.ComiteService;
import com.unicauca.procesos.service.ResponsablePlanMejoramientoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Responsable plan mejoramiento Controller" , description = "Serviciones relacionados con el responsable del plan de mejoramiento")
@RestController
@RequestMapping("/api/planMejoramiento")
public class ResponsablePlanMejoramientoController {
	@Autowired
	private ResponsablePlanMejoramientoService responsablePlanMejoramientoService;

	@Operation(summary = "Crear o editar responsable plan mejoramiento por su proceso")
	@PostMapping("/crear")
	public ResponsablePlanMejoramientoDTO crearResponsablePlanMejoramiento(final @RequestBody ResponsablePlanMejoramientoDTO res) {
		return this.responsablePlanMejoramientoService.crear(res);
	}

	@GetMapping("/consultarPorIdProceso/{id}")
	public ResponsablePlanMejoramientoDTO consultarResponsablePorIdProceso(final @PathVariable Long id) {
		return this.responsablePlanMejoramientoService.obtenerResponsablePlanMejoramientoPorIdProceso(id);
	}
}
