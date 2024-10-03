package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.ResponsableAcreditacionDTO;
import com.unicauca.procesos.service.ResponsableAcreditacionService;
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
@Tag(name = "Responsable Acreditación Controller" , description = "Serviciones relacionados con el responsable de Acreditación")
@RestController
@RequestMapping("/api/responsableAcreditacion")
public class ResponsableAcreditacionController {
	@Autowired
	private ResponsableAcreditacionService responsableAcreditacionService;

	@Operation(summary = "Crear responsable Acreditación")
	@PostMapping("/crear")
	private ResponsableAcreditacionDTO crearResponsable(final @RequestBody ResponsableAcreditacionDTO dto) {
		return this.responsableAcreditacionService.crear(dto);
	}
	@Operation(summary = "Listar todos los responsable Acreditación por programa")
	@GetMapping("/listar/{idPrograma}/{idProceso}")
	private List<ResponsableAcreditacionDTO> listarResponsable(final @PathVariable Long idPrograma, final @PathVariable Long idProceso) {
		return this.responsableAcreditacionService.listarResponsableAcreditacionPorPrograma(idPrograma, idProceso);
	}
	@Operation(summary = "Eliminar el responsable Acreditación por el id")
	@PostMapping("/eliminarResponsable/{id}")
	private Boolean eliminarResponsable(final @PathVariable Long id) {
		return this.responsableAcreditacionService.eliminarResponsable(id);
	}
	@Operation(summary = "Consultar el responsable Acreditación por el id")
	@GetMapping("/consultar/{id}")
	private ResponsableAcreditacionDTO consultarResponsableAcreditacion(final @PathVariable Long id) {
		return this.responsableAcreditacionService.consultarResponsablePorIdResponsable(id);
	}
}
