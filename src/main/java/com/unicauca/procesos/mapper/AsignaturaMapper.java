package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.dto.asignatura.AsignaturaDto;

public class AsignaturaMapper {
	private AsignaturaMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static Asignatura mappearEntidad(AsignaturaDto asignaturaDto) {
		return Asignatura.builder().nombre(asignaturaDto.getNombre())
				.asignaturaSemestre(asignaturaDto.getAsignaturaSemestre())
				.areaFormacion(asignaturaDto.getAreaFormacion())
				.creditos(asignaturaDto.getCreditos())
				.docenciaDirectaPractica(asignaturaDto.getDocenciaDirectaPractica())
				.docenciaDirectaTeorica(asignaturaDto.getDocenciaDirectaTeorica())
				.docenciaIndPractica(asignaturaDto.getDocenciaIndPractica())
				.docenciaIndTeorica(asignaturaDto.getDocenciaIndTeorica())
				.tipoAsignatura(asignaturaDto.getTipoAsignatura())
				.id(asignaturaDto.getId())
				.planEstudio(asignaturaDto.getPlanEstudio()).build();
	}

	public static AsignaturaDto mappearAsignaturaDto(Asignatura entidad) {
		return AsignaturaDto.builder().nombre(entidad.getNombre())
				.asignaturaSemestre(entidad.getAsignaturaSemestre())
				.areaFormacion(entidad.getAreaFormacion())
				.creditos(entidad.getCreditos())
				.docenciaDirectaPractica(entidad.getDocenciaDirectaPractica())
				.docenciaDirectaTeorica(entidad.getDocenciaDirectaTeorica())
				.docenciaIndPractica(entidad.getDocenciaIndPractica())
				.docenciaIndTeorica(entidad.getDocenciaIndTeorica())
				.tipoAsignatura(entidad.getTipoAsignatura())
				.id(entidad.getId())
				.planEstudio(entidad.getPlanEstudio()).build();
	}
}
