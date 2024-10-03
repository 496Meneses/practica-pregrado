package com.unicauca.procesos.controller;

import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.dto.asignatura.AsignaturaDto;
import com.unicauca.procesos.service.AsignaturaService;
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
@Tag(name = "Asignatura Controller" , description = "Serviciones relacionados con la asignatura")
@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaService;
	@Operation(summary = "Crear asignatura")
    @PostMapping("/crear")
    public Asignatura crearAsignatura(@RequestBody AsignaturaDto asignaturaDto) {
		return asignaturaService.crearAsignatura(asignaturaDto);
    }
	@Operation(summary = "Listar asignatura")
	@PostMapping("/listar")
	public Page<AsignaturaDto> listarAsignatura(@RequestBody AsignaturaDto asignaturaDto) {
		return asignaturaService.listar(asignaturaDto);
	}
	@Operation(summary = "Eliminar asignatura")
	@PostMapping("/eliminar")
	public Boolean eliminarAsignatura(@RequestBody Long id) {
		return asignaturaService.eliminarAsignatura(id);
	}
	@Operation(summary = "Obener asignaturas del plan de estudios")
	@GetMapping("/listarAsignaturasPorPlanEstudios/{idPlanEstudios}")
	public List<AsignaturaDto> listarAsignaturasPlanEstudios(@PathVariable Long idPlanEstudios) {
		return asignaturaService.listarAsignaturasDelPlanDeEstudios(idPlanEstudios);
	}
}
