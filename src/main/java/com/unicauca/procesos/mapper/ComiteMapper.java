package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Comite;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.domain.catalogos.Cargo;
import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.dto.comite.ComiteReporte;
import org.springframework.stereotype.Service;

public class ComiteMapper {
	private ComiteMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static Comite mapearEntidad(ComiteDTO comiteDTO) {
		Programa programa = new Programa();
		Proceso proceso = new Proceso();
		proceso.setId(comiteDTO.getIdProceso());
		programa.setId(comiteDTO.getIdPrograma());
		Cargo cargo = new Cargo();
		cargo.setId(comiteDTO.getIdCargo());
		return Comite.builder().id(comiteDTO.getIdComite())
				.nombre(comiteDTO.getNombreCompleto())
				.programa(programa).cargo(cargo)
				.proceso(proceso)
				.build();
	}

	public static ComiteDTO mapearDTO(Comite comite) {
		return ComiteDTO.builder().nombreCompleto(comite.getNombre()).idComite(comite.getId()).idCargo(comite.getCargo().getId())
				.idPrograma(comite.getPrograma().getId())
				.descripcionCargo(comite.getCargo().getDescripcion())
				.build();
	}

	public static ComiteReporte mapEntidadComiteReporte(Comite comite) {
		return ComiteReporte.builder()
				.nombreIntegrante(comite.getNombre())
				.cargo(comite.getCargo().getNombre())
				.build();
	}
}
