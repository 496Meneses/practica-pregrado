package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Archivo;
import com.unicauca.procesos.domain.CronogramaActividad;
import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.domain.catalogos.TipoFuente;
import com.unicauca.procesos.domain.catalogos.TipoPublico;
import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesDTO;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;

public class ArchivoMapper {
	private ArchivoMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }
	public static Archivo mapearEntidad(ArchivoDTO dto) {
		FuenteInformacion.builder().id(dto.getIdFuenteInformacion());
		FuenteInformacion fuente = new FuenteInformacion();
		fuente.setId(dto.getIdFuenteInformacion());
		return Archivo.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
				.link(dto.getLink())
				.fuenteInformacion(fuente)
				.build();
	}
	public static ArchivoDTO mapearDTO(Archivo entidad) {
		return ArchivoDTO.builder()
				.nroAnexo(entidad.getNroAnexo())
				.id(entidad.getId())
				.idFuenteInformacion(entidad.getFuenteInformacion().getId())
				.link(entidad.getLink())
				.nombre(entidad.getNombre())
				.build();
	}
}
