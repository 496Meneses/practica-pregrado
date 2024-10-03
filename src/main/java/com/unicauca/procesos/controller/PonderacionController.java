package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import com.unicauca.procesos.service.FuenteInformacionService;
import com.unicauca.procesos.service.PonderacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Ponderacion Controller" , description = "Serviciones relacionados a las ponderaciones")
@RestController
@RequestMapping("/api/ponderacion")
public class PonderacionController {
	@Autowired
	private PonderacionService ponderacionService;

	@Operation(summary = "Crear ponderacion")
	@PostMapping("/crear")
	public PonderacionDTO crearPonderacion(final @RequestBody PonderacionDTO ponderacion) {
		return this.ponderacionService.crear(ponderacion);
	}
	@Operation(summary = "Crear ponderacion")
	@PostMapping("/crearLista")
	public List<PonderacionDTO> crearPonderacion(final @RequestBody List<PonderacionDTO> ponderacion) {
		return this.ponderacionService.crearLista(ponderacion);
	}
	@Operation(summary = "Listar todas ponderaciones por caracteristica o factor")
	@GetMapping("/listar/{idProceso}/{factor}/{idFactor}")
	public List<PonderacionDTO> listarPonderacionPorFactorOCaracteristica(final @PathVariable Long idProceso, final @PathVariable boolean factor, final @PathVariable Long idFactor) {
		return this.ponderacionService.listarPonderacionPorFactoresOCaracteristicas(idProceso, factor, idFactor);
	}
	@Operation(summary = "Listar ponderacion por aspecto")
	@GetMapping("/listarAspectos/{idProceso}/{idCaracteristica}")
	public List<PonderacionDTO> listarPonderacionPorIdProcesoYCaracteristica(final @PathVariable Long idProceso, final @PathVariable Long idCaracteristica) {
		return this.ponderacionService.listarPonderacionPorIdProcesoCaracteristicaYIdDiferenteDeNullo(idProceso, idCaracteristica);
	}
	@Operation(summary = "Obtener ponderación por id Caracteristica")
	@GetMapping("/obtenerPonderacionCaracteristica/{idProceso}/{idCaracteristica}")
	public PonderacionDTO obtenerPonderacionPorIdCaracteristica(final @PathVariable Long idProceso, final @PathVariable Long idCaracteristica) {
		return this.ponderacionService.obtenerPonderacionDeLaCaracteristica(idProceso, idCaracteristica);
	}
	@Operation(summary = "Eliminar la ponderacion por id")
	@GetMapping("/eliminar/{id}")
	public Boolean eliminarPonderacion(final @PathVariable Long id) {
		return this.ponderacionService.eliminarPonderacion(id);
	}
	@Operation(summary = "Obtener ponderación por id Factor")
	@GetMapping("/obtenerPonderacionFactor/{idProceso}/{idFactor}")
	public PonderacionDTO obtenerPonderacionPorIdFactor(final @PathVariable Long idProceso, final @PathVariable Long idFactor) {
		return this.ponderacionService.obtenerPonderacionDelFactor(idProceso, idFactor);
	}
}
