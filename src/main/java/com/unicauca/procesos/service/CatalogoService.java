package com.unicauca.procesos.service;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.Rol;
import com.unicauca.procesos.domain.catalogos.*;

import java.util.List;

public interface CatalogoService {
	public List<TipoDeVinculacion> listarTipoVinculacion();
	public List<Escalafon>  listarEscalafon();
	public List<TipoPublicacion>  listarTipoPublicacion();

	List<NivelFormacion> listarNivelFormacion();

	List<AsignaturaSemestre> listarAsignaturaSemestre();
	List<TipoAsignatura> listarTipoAsignatura();
	List<Cargo> listarCargo();

	List<TipoPublico> listarTipoPublico();

	List<TipoFuente> listarTipoFuente();
	List<TipoCalificacion> listarTipoCalificacion();
	List<Factor> listarFactores();
	List<Caracteristica> listarCaracteristicas(Long factorId);

    List<Aspecto> listarAspectos(Long caracteristicaId);
	List<Rol> listarRoles();

    List<CatResultadoAprendizaje> listarResultadosAprendizaje(Long idPrograma, Long idProceso);
	List<Estado> listarEstado();
}
