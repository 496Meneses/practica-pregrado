package com.unicauca.procesos.mapper;

import com.unicauca.procesos.domain.Docente;
import com.unicauca.procesos.domain.Persona;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.domain.catalogos.Escalafon;
import com.unicauca.procesos.domain.catalogos.TipoDeVinculacion;
import com.unicauca.procesos.dto.docente.DocenteListaResponse;
import com.unicauca.procesos.dto.docente.DocenteReporte;
import com.unicauca.procesos.dto.docente.DocenteRequest;
import com.unicauca.procesos.dto.docente.DocenteResponse;
import com.unicauca.procesos.dto.persona.PersonaResponse;
import com.unicauca.procesos.repository.CatEscalafonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DocenteMapper {

	public static Docente mapearEntidad(DocenteRequest docenteDto) {
		Programa programa = new Programa();
		programa.setId(docenteDto.getIdPrograma());
		Escalafon escalafon = Escalafon.builder().id(docenteDto.getIdEscalafon()).build();
		TipoDeVinculacion tipoDeVinculacion = TipoDeVinculacion.builder().id(docenteDto.getIdVinculacion()).build();
		return Docente.builder().aniosExperenciaDocente(docenteDto.getAniosExperienciaDocente())
				.titulosPregrado(docenteDto.getTitulosPregrado())
				.titulosPosgrado(docenteDto.getTitulosPosgrado())
				.aniosExperienciaLaboral(docenteDto.getAniosExperienciaLaboral())
				.aniosExperenciaDocente(docenteDto.getAniosExperienciaDocente())
				.experticia(docenteDto.getExperticia())
				.vinculacion(tipoDeVinculacion)
				.programa(programa)
				.id(docenteDto.getId())
				.escalafon(escalafon).build();
	}

	public  static DocenteResponse mapearRespuesta(Docente docenteDto) {
		return DocenteResponse.builder()
				.persona(PersonaResponse.builder().nombres(docenteDto.getPersona().getNombres())
						.apellidos(docenteDto.getPersona().getApellidos()).id(docenteDto.getPersona().getId()).build())
				.titulosPregrado(docenteDto.getTitulosPregrado())
				.titulosPosgrado(docenteDto.getTitulosPosgrado())
				.aniosExperienciaLaboral(docenteDto.getAniosExperienciaLaboral())
				.aniosExperienciaDocente(docenteDto.getAniosExperenciaDocente())
				.experticia(docenteDto.getExperticia())
				.idVinculacion(docenteDto.getVinculacion().getId())
				.id(docenteDto.getId())
				.idPrograma(docenteDto.getPrograma().getId())
				.publicaciones(docenteDto.getPublicaciones().stream().map(PublicacionMapper::mapearRespuesta).collect(Collectors.toList()))
				.idEscalafon(docenteDto.getEscalafon().getId()).build();

	}

	public static DocenteListaResponse mapearRespuestaListaDocente(Docente docente) {
		return DocenteListaResponse.builder()
				.id(docente.getId())
				.idEscalafon(docente.getEscalafon().getId())
				.idPrograma(docente.getPrograma().getId())
				.desPrograma(docente.getPrograma().getNombre())
				.nombres(docente.getPersona().getNombres()).apellidos(docente.getPersona().getApellidos())
				.build();
	}

	public static DocenteReporte mapearEntidadADocenteReporte(Docente docente) {
		return DocenteReporte.builder()
				.aniosExperienciaProfesional(String.valueOf(docente.getAniosExperienciaLaboral()))
				.escalafon(String.valueOf(docente.getEscalafon().getDescripcion()))
				.tipoDeVinculacion(docente.getVinculacion().getDescripcion())
				.anosExpDocente(String.valueOf(docente.getAniosExperenciaDocente()))
				.nombres(docente.getPersona().getNombres())
				.apellidos(docente.getPersona().getApellidos())
				.build();
	}
}
