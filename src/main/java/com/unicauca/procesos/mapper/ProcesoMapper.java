package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.catalogos.TipoFuente;
import com.unicauca.procesos.domain.catalogos.TipoPublico;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.dto.proceso.ProcesoDTO;

import java.util.stream.Collectors;

public class ProcesoMapper {
	private ProcesoMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static ProcesoDTO mapearDTO(Proceso entidad) {
		return ProcesoDTO.builder().id(entidad.getId())
				.fechaFin(entidad.getFechaFinalizacion())
				.fechaInicio(entidad.getFechaInicio())
				.estado(entidad.getEstado().getDescripcion())
				.idPrograma(entidad.getId())
				.activo(entidad.getActivo())
				.justificacionEvaluacion(entidad.getJustificacionEvaluacion())
				.build();
	}
}
