package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesDTO;
import com.unicauca.procesos.service.ComiteService;
import com.unicauca.procesos.service.CronogramaActividadesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Cronograma Actividad Controller" , description = "Servicios relacionados con la creación de un cronograma de actividades para un determinado programa")
@RestController
@RequestMapping("/api/cronogramaActividad")
public class CronogramaActividadController {
	@Autowired
	private CronogramaActividadesService cronogramaActividadesService;

	@Operation(summary = "Crear actividad para el cronograma")
	@PostMapping("/crear")
	public CronogramaActividadesDTO crearCronogramaActividad(final @RequestBody CronogramaActividadesDTO dto) {
		return this.cronogramaActividadesService.crear(dto);
	}
	@Operation(summary = "Listar todos los cronogramas de actividades por el programa")
	@GetMapping("/listar/{idPrograma}/{idProceso}")
	public List<CronogramaActividadesDTO> listarCronograma(final @PathVariable Long idPrograma, final @PathVariable Long idProceso) {
		return this.cronogramaActividadesService.listarConogramaActividadesPorIdPrograma(idPrograma, idProceso);
	}
	@Operation(summary = "Eliminar el cronogramas de actividades por el id")
	@PostMapping("/eliminarCronograma/{id}")
	public Boolean eliminarCronograma(final @PathVariable Long id) {
		return this.cronogramaActividadesService.eliminarConogramaActividades(id);
	}

	@GetMapping("consultar/{id}")
	public CronogramaActividadesDTO consultarCronograma(final @PathVariable Long id) {
		return this.cronogramaActividadesService.consultarCronogramaPorId(id);
	}
}
