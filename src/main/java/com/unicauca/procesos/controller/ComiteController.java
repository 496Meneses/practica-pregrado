package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.service.ComiteService;
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
@Tag(name = "Comite Controller" , description = "Serviciones relacionados con el comite")
@RestController
@RequestMapping("/api/comite")
public class ComiteController {
	@Autowired
	private ComiteService comiteService;

	@Operation(summary = "Crear comite")
	@PostMapping("/crear")
	public ComiteDTO crearComite(final @RequestBody ComiteDTO comite) {
		return this.comiteService.crear(comite);
	}
	@Operation(summary = "Listar todos los comites por el programa")
	@GetMapping("/listar/{idPrograma}/{idProceso}")
	public List<ComiteDTO> listarComite(final @PathVariable Long idPrograma, final @PathVariable Long idProceso) {
		return this.comiteService.listarComitePrograma(idPrograma, idProceso);
	}
	@Operation(summary = "Eliminar el comite por el id")
	@PostMapping("/eliminarComite/{id}")
	public Boolean eliminarComite(final @PathVariable Long id) {
		return this.comiteService.eliminarComite(id);
	}

	@GetMapping("/consultar/{id}")
	public ComiteDTO consultarComite(final @PathVariable Long id) {
		return this.comiteService.consultarComitePorId(id);
	}
}
