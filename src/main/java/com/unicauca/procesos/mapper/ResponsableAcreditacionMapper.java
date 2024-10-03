package com.unicauca.procesos.mapper;

import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.domain.ResponsableAcreditacion;
import com.unicauca.procesos.domain.catalogos.Cargo;
import com.unicauca.procesos.dto.ResponsableAcreditacionDTO;
import com.unicauca.procesos.dto.ResponsableAcreditacionReporte;
import org.springframework.stereotype.Service;

@Service
public class ResponsableAcreditacionMapper {

	public static ResponsableAcreditacion mapearEntidad(ResponsableAcreditacionDTO dto) {
		Cargo cargo = new Cargo();
		cargo.setId(dto.getIdCargo());
		Programa programa = new Programa();
		programa.setId(dto.getIdPrograma());
		Proceso proceso = new Proceso();
		proceso.setId(dto.getIdProceso());
		return ResponsableAcreditacion.builder().id(dto.getId()).correo(dto.getCorreo())
				.proceso(proceso)
				.cargo(cargo).programa(programa).telefono(dto.getTelefono()).nombre(dto.getNombre()).build();
	}

	public static ResponsableAcreditacionDTO mapearDTO(ResponsableAcreditacion entidad) {
		return ResponsableAcreditacionDTO.builder().id(entidad.getId()).
				correo(entidad.getCorreo())
				.idCargo(entidad.getCargo().getId())
				.idPrograma(entidad.getPrograma().getId())
				.telefono(entidad.getTelefono())
				.nombre(entidad.getNombre())
				.descripcionCargo(entidad.getCargo().getDescripcion())
				.build();
	}

	public static ResponsableAcreditacionReporte mapEntidadResponsableReporte(ResponsableAcreditacion responsable) {
		return ResponsableAcreditacionReporte.builder()
				.nombreResponsable(responsable.getNombre())
				.email(responsable.getCorreo())
				.dependenciaAdscrito("Sin registro")
				.cargo(responsable.getCargo().getDescripcion())
				.telefono(responsable.getTelefono())
				.build();
	}
}
