package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Docente;
import com.unicauca.procesos.domain.Persona;
import com.unicauca.procesos.domain.Publicacion;
import com.unicauca.procesos.dto.docente.DocenteListaResponse;
import com.unicauca.procesos.dto.docente.DocenteRequest;
import com.unicauca.procesos.dto.docente.DocenteResponse;
import com.unicauca.procesos.mapper.DocenteMapper;
import com.unicauca.procesos.mapper.PersonaMapper;
import com.unicauca.procesos.mapper.PublicacionMapper;
import com.unicauca.procesos.repository.CatEscalafonRepository;
import com.unicauca.procesos.repository.CatTipoVinculacionRepository;
import com.unicauca.procesos.repository.DocenteRepository;
import com.unicauca.procesos.repository.PersonaRepository;
import com.unicauca.procesos.repository.PublicacionRepository;
import com.unicauca.procesos.service.DocenteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private PublicacionRepository publicacionRepository;
	private CatTipoVinculacionRepository catTipoVinculacionRepository;
	private CatEscalafonRepository catEscalafonRepository;

	@Override
	public DocenteResponse crear(DocenteRequest docenteRequest) {
		Docente docente;
		if (docenteRequest.getId() == null) {
			docente = DocenteMapper.mapearEntidad(docenteRequest);
			Persona persona = PersonaMapper.crearPersona(docenteRequest.getNombres(), docenteRequest.getApellidos());
			persona = personaRepository.save(persona);
			docente.setPersona(persona);
			List<Publicacion> publicaciones = docenteRequest.getPublicaciones().stream().map(PublicacionMapper::mapearEntidad).collect(Collectors.toList());
			docente.setPublicaciones(publicaciones);
		}
		else {
			docente = this.docenteRepository.getById(docenteRequest.getId());
			docente.setEscalafon(catEscalafonRepository.findById(docenteRequest.getIdEscalafon()).get());
			docente.setVinculacion(catTipoVinculacionRepository.findById(docenteRequest.getIdVinculacion()).get());
			docente.setAniosExperenciaDocente(docenteRequest.getAniosExperienciaDocente());
			docente.setAniosExperienciaLaboral(docenteRequest.getAniosExperienciaLaboral());
			docente.setExperticia(docenteRequest.getExperticia());
			Persona persona = this.personaRepository.getById(docenteRequest.getPersona().getId());
			persona.setNombres(docenteRequest.getNombres());
			persona.setApellidos(docenteRequest.getApellidos());
			this.personaRepository.save(persona);
			List<Publicacion> publicaciones = docenteRequest.getPublicaciones().stream().map(PublicacionMapper::mapearEntidad).collect(Collectors.toList());
			docente.setPublicaciones(publicaciones);
			docente.setPersona(persona);
		}
		docente = this.docenteRepository.save(docente);
		if (null != docente.getId()) {
			return DocenteMapper.mapearRespuesta(docente);
		}
		return null;
	}

	@Override
	public Page<DocenteListaResponse> listar(final int pageNumber, final int pageSize, Long idPrograma) {
		Page<Docente> page = this.docenteRepository.findByProgramaId(idPrograma, PageRequest.of(pageNumber, pageSize)) ;
		return page.map(DocenteMapper:: mapearRespuestaListaDocente);
	}

	@Override
	public DocenteResponse eliminar(Long id) {
		// VALIDAR SI EL DOCENTE NO PERTENECE A UN PROGRAMA TODO
		Docente docente = this.docenteRepository.getById(id);
		this.personaRepository.deleteById(docente.getPersona().getId());
		docente.getPublicaciones().forEach(publicacion -> {
			this.publicacionRepository.deleteById(publicacion.getId());
		});
		this.docenteRepository.deleteById(id);
		return null;
	}

	@Override
	public DocenteResponse editar(DocenteRequest docenteRequest) {
		Docente docente = this.docenteRepository.getById(docenteRequest.getId());
		docente = DocenteMapper.mapearEntidad(docenteRequest);
		this.docenteRepository.save(docente);
		return this.crear(docenteRequest);
	}

	@Override
	public DocenteResponse buscarPorId(Long idDocente) {
		Docente docente = this.docenteRepository.getById(idDocente);
		return DocenteMapper.mapearRespuesta(docente);
	}

	@Override
	public List<DocenteListaResponse> listarDocentesCatalogo(Long idPrograma) {
		return this.docenteRepository.findByProgramaId(idPrograma).stream().map(DocenteMapper::mapearRespuestaListaDocente).collect(Collectors.toList());
	}

}
