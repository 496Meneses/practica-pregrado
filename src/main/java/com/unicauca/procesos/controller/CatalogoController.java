package com.unicauca.procesos.controller;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.Rol;
import com.unicauca.procesos.domain.catalogos.*;
import com.unicauca.procesos.service.CatalogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Catalogo Controller" , description = "Servicio para obtener los catalogos")
@RestController
@RequestMapping("/api/catalogos")
public class CatalogoController {
	@Autowired
	private CatalogoService catalogoService;

	@Operation(summary = "Listar catalogo vinculacion")
	@GetMapping("/tipoVinculacion")
	public List<TipoDeVinculacion> listarCatalogoVinculacion() {
		return this.catalogoService.listarTipoVinculacion();
	}
	@Operation(summary = "Listar catalogo escalafon")
	@GetMapping("/escalafon")
	public List<Escalafon> listarCatalogoEscalafon() {
		return this.catalogoService.listarEscalafon();
	}
	@Operation(summary = "Listar catalogo tipo publicacion")
	@GetMapping("/tipoPublicacion")
	public List<TipoPublicacion> listarCatalogoTipoPublicacion() {
		return this.catalogoService.listarTipoPublicacion();
	}
	@Operation(summary = "Listar catalogo nivel formacion")
	@GetMapping("/nivelFormacion")
	public List<NivelFormacion> listarCatalogoNivelFormacion() {
		return this.catalogoService.listarNivelFormacion();
	}
	@Operation(summary = "Listar catalogo asignatura semestre")
	@GetMapping("/asignaturaSemestre")
	public List<AsignaturaSemestre> listarAsignaturaSemestre() {
		return this.catalogoService.listarAsignaturaSemestre();
	}
	@Operation(summary = "Listar catalogo tipo asignatura")
	@GetMapping("/tipoAsignatura")
	public List<TipoAsignatura> listarTipoAsignatura() {
		return this.catalogoService.listarTipoAsignatura();
	}
	@Operation(summary = "Listar catalogo cargo")
	@GetMapping("/cargo")
	public List<Cargo> listarCargo() {
		return this.catalogoService.listarCargo();
	}
	@Operation(summary = "Listar catalogo tipo publico")
	@GetMapping("/tipoPublico")
	public List<TipoPublico> listarTipoPublico() {
		return this.catalogoService.listarTipoPublico();
	}
	@Operation(summary = "Listar catalogo tipo fuente")
	@GetMapping("/tipoFuente")
	public List<TipoFuente> listarCatalogoTipoFuente() {
		return this.catalogoService.listarTipoFuente();
	}
	@Operation(summary = "Listar catalogo tipo calificacion")
	@GetMapping("/tipoCalificacion")
	public List<TipoCalificacion> listarCatalogoTipoCalificacion() {
		return this.catalogoService.listarTipoCalificacion();
	}
	@Operation(summary = "Listar catalogo factores")
	@GetMapping("/factores")
	public List<Factor> listarCatalogoFactores() {
		return this.catalogoService.listarFactores();
	}
	@Operation(summary = "Listar catalogo caracteristicas")
	@GetMapping("/caracteristicas/{factorId}")
	public List<Caracteristica> listarCatalogoCaracteristicas(@PathVariable Long factorId) {
		return this.catalogoService.listarCaracteristicas(factorId);
	}
	@Operation(summary = "Listar catalogo aspecto")
	@GetMapping("/aspectos/{caracteristicaId}")
	public List<Aspecto> listarCatalogoAspectos(@PathVariable Long caracteristicaId) {
		return this.catalogoService.listarAspectos(caracteristicaId);
	}
	@Operation(summary = "Listar catalogo roles")
	@GetMapping("/roles")
	public List<Rol> listarCatalogoRoles() {
		return this.catalogoService.listarRoles();
	}
	@Operation(summary = "Listar resultados aprendizaje programa")
	@GetMapping("/resultadosAprendizaje/{idPrograma}/{idProceso}")
	public List<CatResultadoAprendizaje> listarCatResultadosAprendizaje(@PathVariable  Long idPrograma, @PathVariable  Long idProceso) {
		return this.catalogoService.listarResultadosAprendizaje(idPrograma, idProceso);
	}
}
