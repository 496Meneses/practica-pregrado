package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.service.ComiteService;
import com.unicauca.procesos.service.FuenteInformacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Fuente informacion Controller" , description = "Serviciones relacionados las fuentes de informacion")
@RestController
@RequestMapping("/api/fuenteInformacion")
public class FuenteInformacionController {
	@Autowired
	private FuenteInformacionService fuenteInformacionService;

	@Operation(summary = "Crear fuente de informacion")
	@PostMapping("/crear")
	public FuenteInformacionDTO crearFuente(final @RequestBody FuenteInformacionDTO fuente) {
		return this.fuenteInformacionService.crear(fuente);
	}
	@Operation(summary = "Listar todas las fuentes de informacion por tipo")
	@GetMapping("/listar/{idProceso}/{documental}")
	public List<FuenteInformacionDTO> listarFuenteInformacion(final @PathVariable Long idProceso, final @PathVariable boolean documental) {
		return this.fuenteInformacionService.listarFuentesDocumentales(idProceso, documental);
	}
	@Operation(summary = "Eliminar la fuente de informacion por el id")
	@PostMapping("/eliminar/{id}")
	public Boolean eliminarFuente(final @PathVariable Long id) {
		return this.fuenteInformacionService.eliminarFuenteInformacion(id);
	}
	@Operation(summary = "Consultar fuente informacion por el id")
	@GetMapping("/consultar/{id}")
	public FuenteInformacionDTO consultarFuenteInformacion(final @PathVariable Long id) {
		return this.fuenteInformacionService.consultarFuenteInformacionPorId(id);
	}
	@Operation(summary = "Eliminar archivo por ID")
	@GetMapping("/eliminarArchivo/{id}")
	public Boolean eliminarArchivo(final @PathVariable Long id) {
		return this.fuenteInformacionService.eliminarArchivoPorId(id);
	}
}
