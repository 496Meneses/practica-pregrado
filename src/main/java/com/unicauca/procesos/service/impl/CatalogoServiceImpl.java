package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.Rol;
import com.unicauca.procesos.domain.catalogos.*;
import com.unicauca.procesos.repository.*;
import com.unicauca.procesos.service.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {
	@Autowired
	private CatTipoVinculacionRepository tipoVinculacionRepository;
	@Autowired
	private CatEscalafonRepository escalafonRepository;
	@Autowired
	private CatTipoPublicacionRepository tipoPublicacionRepository;
	@Autowired
	private CatNivelFormacionRepository nivelFormacionRepository;
	@Autowired
	private CatAsignaturaSemestreRepository catAsignaturaSemestreRepository;
	@Autowired
	private CatTipoAsignaturaRepository catTipoAsignaturaRepository;
	@Autowired
	private CatCargosRepository catCargosRepository;
	@Autowired
	private CatTipoPublicoRepository catTipoPublicoRepository;
	@Autowired
	private CatTipoFuenteRepository catTipoFuenteRepository;
	@Autowired
	private CatTipoCalificacionRepository catTipoCalificacionRepository;
	@Autowired
	private CatFactorRepository catFactorRepository;
	@Autowired
	private CatCaracteristicaRepository catCaracteristicaRepository;
	@Autowired
	private CatAspectoRepository catAspectoRepository;
	@Autowired
	private CatRolRepository rolRepository;
	@Autowired
	private CatResultadoAprendizajeRepository catResultadoAprendizajeRepository;
	@Autowired
	private CatEstadoRepository catEstadoRepository;

	@Override
	public List<TipoDeVinculacion> listarTipoVinculacion() {
		return this.tipoVinculacionRepository.findAll();
	}

	@Override
	public List<Escalafon>  listarEscalafon() {
		return this.escalafonRepository.findAll();
	}

	@Override
	public List<TipoPublicacion> listarTipoPublicacion() {
		return tipoPublicacionRepository.findAll();
	}

	@Override
	public List<NivelFormacion> listarNivelFormacion() {
		return nivelFormacionRepository.findAll();
	}

	@Override
	public List<AsignaturaSemestre> listarAsignaturaSemestre() {
		return catAsignaturaSemestreRepository.findAll();
	}

	@Override
	public List<TipoAsignatura> listarTipoAsignatura() {
		return this.catTipoAsignaturaRepository.findAll();
	}

	@Override
	public List<Cargo> listarCargo() {
		return this.catCargosRepository.findAll();
	}

	@Override
	public List<TipoPublico> listarTipoPublico() {
		return this.catTipoPublicoRepository.findAll();
	}

	@Override
	public List<TipoFuente> listarTipoFuente() {
		return this.catTipoFuenteRepository.findAll();
	}

	@Override
	public List<TipoCalificacion> listarTipoCalificacion() {
		return catTipoCalificacionRepository.findAll();
	}

	@Override
	public List<Factor> listarFactores() {
		return this.catFactorRepository.findAll();
	}

	@Override
	public List<Caracteristica> listarCaracteristicas(Long factorId) {
		return this.catCaracteristicaRepository.findByFactorId(factorId);
	}

	@Override
	public List<Aspecto> listarAspectos(Long caracteristicaId) {
		return this.catAspectoRepository.findByCaracteristicaId(caracteristicaId);
	}

	@Override
	public List<Rol> listarRoles() {
		return this.rolRepository.findAll();
	}

	@Override
	public List<CatResultadoAprendizaje> listarResultadosAprendizaje(Long idPrograma, Long idProceso) {
		return this.catResultadoAprendizajeRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso);
	}
	@Override
	public List<Estado> listarEstado() {
		return this.catEstadoRepository.findAll();
	}
}
