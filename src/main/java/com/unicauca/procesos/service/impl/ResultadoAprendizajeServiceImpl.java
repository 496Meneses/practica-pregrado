package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.domain.Docente;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.domain.ResultadoAprendizaje;
import com.unicauca.procesos.domain.catalogos.CatResultadoAprendizaje;
import com.unicauca.procesos.dto.CatResultadoAprendizajeDTO;
import com.unicauca.procesos.dto.CumplimientoRADTO;
import com.unicauca.procesos.repository.*;
import com.unicauca.procesos.service.ResultadoAprendizajeService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Proc;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ResultadoAprendizajeServiceImpl implements ResultadoAprendizajeService {

	private CatResultadoAprendizajeRepository catResultadoAprendizajeRepository;
	private AsignaturaRepository asignaturaRepository;
	private ResultadoAprendizajeRepository resultadoAprendizajeRepository;
	private DocenteRepository docenteRepository;

	@Override
	public CumplimientoRADTO crearCumplimientoAsignatura(CumplimientoRADTO dto) {
		List<ResultadoAprendizaje> entidadesCreadas = new ArrayList<>();
		Asignatura asignatura = new Asignatura();
		asignatura.setId(dto.getIdAsignatura());
		Programa programa = new Programa();
		programa.setId(dto.getIdPrograma());
		dto.getResultadoAprendizaje().forEach(catalogo -> {
			CatResultadoAprendizaje entidadCatalogo = new CatResultadoAprendizaje();
			entidadCatalogo.setId(catalogo.getId());
			ResultadoAprendizaje entidad = new ResultadoAprendizaje();
			entidad.setId(catalogo.getIdResultadoDeAprendizaje());
			entidad.setAsignatura(asignatura);
			entidad.setCumplimiento(catalogo.getCumplimiento());
			entidad.setPrograma(programa);
			entidad.setCatResultadoAprendizaje(entidadCatalogo);
			Proceso proceso = new Proceso();
			proceso.setId(dto.getIdProceso());
			entidad.setProceso(proceso);
			ResultadoAprendizaje resultado = this.resultadoAprendizajeRepository.save(entidad);
			entidadesCreadas.add(resultado);
		});
		List<ResultadoAprendizaje> a = entidadesCreadas;
		return this.mapearListaEntidadAListaCumplimiento(a).get(0);
	}

	@Override
	public List<CumplimientoRADTO> crearListaCumplimientoAsignatura(List<CumplimientoRADTO> dtos) {
		List<CumplimientoRADTO> resultado = new ArrayList<>();
		dtos.stream().filter( dto -> dto.getNotificarCambio() != null && dto.getNotificarCambio() == true).forEach(
				dto -> {
					resultado.add(this.crearCumplimientoAsignatura(dto));
				}
		);
		return resultado;
	}

	@Override
	public List<CumplimientoRADTO> crearListaCumplimientoDocente(List<CumplimientoRADTO> dtos) {
		List<CumplimientoRADTO> resultado = new ArrayList<>();
		dtos.stream().filter( dto -> dto.getNotificarCambio() != null && dto.getNotificarCambio() == true).forEach(

				dto -> {
					resultado.add(this.crearCumplimientoDocente(dto));
				}
		);
		return resultado;
	}

	@Override
	public CumplimientoRADTO crearCumplimientoDocente(CumplimientoRADTO dto) {
		List<ResultadoAprendizaje> entidadesCreadas = new ArrayList<>();
		Docente docente = this.docenteRepository.findById(dto.getIdDocente()).get();
		Programa programa = new Programa();
		programa.setId(dto.getIdPrograma());
		dto.getResultadoAprendizaje().forEach(catalogo -> {
			Optional<CatResultadoAprendizaje> optional = this.catResultadoAprendizajeRepository.findById(catalogo.getId());
			if (optional.isPresent()) {
				ResultadoAprendizaje entidad = new ResultadoAprendizaje();
				entidad.setId(catalogo.getIdResultadoDeAprendizaje());
				entidad.setDocente(docente);
				entidad.setCumplimiento(catalogo.getCumplimiento());
				CatResultadoAprendizaje entidadCatalogo = new CatResultadoAprendizaje();
				entidadCatalogo.setId(catalogo.getId());
				entidad.setCatResultadoAprendizaje(entidadCatalogo);
				entidad.setPrograma(programa);
				ResultadoAprendizaje resultado = this.resultadoAprendizajeRepository.save(entidad);
				entidadesCreadas.add(resultado);
			} else {
				this.resultadoAprendizajeRepository.deleteById(catalogo.getIdResultadoDeAprendizaje());
			}
		});
		List<ResultadoAprendizaje> a = entidadesCreadas;
		return this.mapearListaEntidadAListaCumplimiento(a).get(0);
	}

	@Override
	public List<CumplimientoRADTO> listarCumplimientoAsignatura(Long idPrograma, Long idProceso) {
		List<ResultadoAprendizaje> listaCumplimientoAsignatura = this.resultadoAprendizajeRepository.findByProgramaIdAndProcesoIdAndDocenteIdIsNull(idPrograma, idProceso);
		List<CumplimientoRADTO> a = mapearListaEntidadAListaCumplimiento(listaCumplimientoAsignatura);
		return a;
	}

	// Transforma el resultado de aprendizaje resultante a una lista dto para dar respuesta,
	// si el resultado de aprendizaje tiene asignatura, significa que los resultados de aprendizaje a transformar,
	// son para las asignaturas, sino, son para los docentes.
	public List<CumplimientoRADTO> mapearListaEntidadAListaCumplimiento(List<ResultadoAprendizaje> entidades) {
		// mapa para agrupar obj por id
		Map<Long, List<CatResultadoAprendizajeDTO>> mapa = new HashMap<>();
		Boolean esAsignatura = false; // definidor
		for (ResultadoAprendizaje entidad: entidades) {
			Long id;
			if (entidad.getAsignatura() != null) {
				id = entidad.getAsignatura().getId();
				esAsignatura = true;
			} else {
				id = entidad.getDocente().getId();
				esAsignatura = false;
			}
			// obtener lista, o crear una nueva para el mapa
			List<CatResultadoAprendizajeDTO> subLista = mapa.getOrDefault(id, new ArrayList<>());
			// construir catDto para agregar a la sublista
			CatResultadoAprendizajeDTO agregar = CatResultadoAprendizajeDTO.builder()
					.cumplimiento(entidad.getCumplimiento())
					.descripcion(entidad.getCatResultadoAprendizaje().getDescripcion())
					.idResultadoDeAprendizaje(entidad.getId())
					.codigo(entidad.getCatResultadoAprendizaje().getCodigo())
					.id(entidad.getCatResultadoAprendizaje().getId()).build();
			// agregar a la sublista
			subLista.add(agregar);
			// actualizar mapa con la sublista actualizada
			mapa.put(id, subLista);
		}
		// Crea una lista final de listas con el id como elemento principal
		List<CumplimientoRADTO> listaFinal = new ArrayList<>();
		for (Map.Entry<Long, List<CatResultadoAprendizajeDTO>> entry : mapa.entrySet()) {
			Docente docente = null;
			if (!esAsignatura) {
				docente = this.docenteRepository.findById(entry.getKey()).get();
			}
			CumplimientoRADTO cumplimientoRADTO = CumplimientoRADTO.builder()
					.idAsignatura(esAsignatura ? entry.getKey(): null) // llenar el id si es asignatura para asignatura
					.desAsignatura(esAsignatura ? this.asignaturaRepository.findById(entry.getKey()).get().getNombre(): null)
					.desDocente(!esAsignatura ? docente.getPersona().getNombres() + " " + docente.getPersona().getApellidos(): null)
					.idDocente(!esAsignatura ? entry.getKey() : null)  // si no es asignatura llenar el id del docente
					.idPrograma(entidades.get(0).getPrograma().getId())
					.resultadoAprendizaje(entry.getValue())
					.build();

			listaFinal.add(cumplimientoRADTO);
		}
		return listaFinal;
	}

	@Override
	public List<CumplimientoRADTO> listarCumplimientoDocente(Long idPrograma) {
		List<ResultadoAprendizaje> entidades = this.resultadoAprendizajeRepository.findByProgramaIdAndDocenteIdIsNotNull(idPrograma);
		List<CumplimientoRADTO> a = mapearListaEntidadAListaCumplimiento(entidades);
		return a;
	}

	@Override
	public CatResultadoAprendizajeDTO crearCatResultadoAprendizaje(CatResultadoAprendizajeDTO dto) {
		Programa programa = new Programa();
		if (dto.getIdPrograma() == null) {
			programa.setId(dto.getPrograma().getId());
		} else {
			programa.setId(dto.getIdPrograma());
		}
		Proceso proceso = Proceso.builder().id(dto.getIdProceso()).build();
		CatResultadoAprendizaje entidad = this.catResultadoAprendizajeRepository.save(CatResultadoAprendizaje.builder()
				.codigo(dto.getCodigo())
				.descripcion(dto.getDescripcion())
				.id(dto.getId())
				.programa(programa)
				.proceso(proceso)
				.build());
		return CatResultadoAprendizajeDTO.builder()
				.idPrograma(entidad.getPrograma().getId())
				.codigo(entidad.getCodigo())
				.descripcion(entidad.getDescripcion())
				.cumplimiento(false)
				.id(entidad.getId())
				.build();

	}

	@Override
	public List<CatResultadoAprendizajeDTO> crearListaCatResultadoAprendizaje(List<CatResultadoAprendizajeDTO> dtos) {
		List<CatResultadoAprendizajeDTO> RdtoS = new ArrayList<>();
		for (CatResultadoAprendizajeDTO dto: dtos) {
			RdtoS.add(this.crearCatResultadoAprendizaje(dto));
		}
		return RdtoS;
	}

	@Override
	public boolean eliminarCatResultadoAprendizaje(Long idCatResultadoAprendizaje) {
		// si vamos a eliminar un catResultado aprendizaje, debemos eliminar los resultados de aprendizaje que tengan este catalogo
		// en la tabla resultado aprendizaje
		List<ResultadoAprendizaje> entidades = this.resultadoAprendizajeRepository.findByCatResultadoAprendizajeId(idCatResultadoAprendizaje);
		for (ResultadoAprendizaje entidad:
				entidades) {
			this.resultadoAprendizajeRepository.deleteById(entidad.getId());
		}
		this.catResultadoAprendizajeRepository.deleteById(idCatResultadoAprendizaje);
		return true;
	}
}
