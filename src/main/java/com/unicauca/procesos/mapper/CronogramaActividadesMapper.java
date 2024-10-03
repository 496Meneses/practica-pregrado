package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.CronogramaActividad;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesDTO;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesReporte;

public class CronogramaActividadesMapper {
	private CronogramaActividadesMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static CronogramaActividad mapearEntidad(CronogramaActividadesDTO dto) {
		Programa programa = new Programa();
		Proceso proceso = new Proceso();
		proceso.setId(dto.getIdProceso());
		programa.setId(dto.getIdPrograma());
		return CronogramaActividad.builder().id(dto.getId())
				.fechaInicio(dto.getFechaInicio())
				.fechaFin(dto.getFechaFin())
				.descripcion(dto.getDescripcion())
				.nombre(dto.getNombre())
				.programa(programa)
				.proceso(proceso)
				.build();
	}

	public static CronogramaActividadesDTO mapearDTO(CronogramaActividad entidad) {
		return CronogramaActividadesDTO.builder().nombre(entidad.getNombre())
				.id(entidad.getId())
				.descripcion(entidad.getDescripcion())
				.fechaFin(entidad.getFechaFin())
				.fechaInicio(entidad.getFechaInicio())
				.idPrograma(entidad.getPrograma().getId())
				.build();
	}

	public static CronogramaActividadesReporte mapearEntidadReporte(CronogramaActividad actividad) {
		return CronogramaActividadesReporte.builder()
				.descripcion(actividad.getDescripcion())
				.fechaFin(actividad.getFechaInicio().toString())
				.fechaInicio(actividad.getFechaFin().toString())
				.nombre(actividad.getNombre())
				.descripcion(actividad.getDescripcion())
				.build();
	}
}
