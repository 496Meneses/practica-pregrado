package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.*;
import com.unicauca.procesos.domain.catalogos.Cargo;
import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.ResponsablePlanMejoramientoDTO;

public class ResponsablePlanMejoramientoMapper {
	private ResponsablePlanMejoramientoMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static ResponsablePlanMejoramiento mapearEntidad(ResponsablePlanMejoramientoDTO dto) {
		Cargo cargo = Cargo.builder().id(dto.getIdCargo()).build();
		return ResponsablePlanMejoramiento.builder()
				.id(dto.getId())
				.nombre(dto.getNombreResponsable())
				.cargo(cargo)
				.correo(dto.getCorreo())
				.dependencia(dto.getDependencia())
				.programa(Programa.builder().id(dto.getIdPrograma()).build())
				.telefono(dto.getTelefono())
				.proceso(Proceso.builder().id(dto.getIdProceso()).build())
				.build();
	}

	public static ResponsablePlanMejoramientoDTO mapearDTO(ResponsablePlanMejoramiento entidad) {
		return ResponsablePlanMejoramientoDTO.builder()
				.id(entidad.getId())
				.dependencia(entidad.getDependencia())
				.idCargo(entidad.getCargo().getId())
				.desCargo(entidad.getCargo().getDescripcion())
				.telefono(entidad.getTelefono())
				.nombreResponsable(entidad.getNombre())
				.idProceso(entidad.getProceso().getId())
				.correo(entidad.getCorreo())
				.build();
	}
}
