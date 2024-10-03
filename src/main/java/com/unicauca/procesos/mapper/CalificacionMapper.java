package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Calificacion;
import com.unicauca.procesos.domain.Ponderacion;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.catalogos.Caracteristica;
import com.unicauca.procesos.domain.catalogos.Factor;
import com.unicauca.procesos.dto.CalificacionDTO;
import com.unicauca.procesos.dto.CalificacionReporte;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;

public class CalificacionMapper {
	private CalificacionMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static Calificacion mapearEntidad(CalificacionDTO dto) {
		Proceso proceso = new Proceso();
		proceso.setId(dto.getIdProceso());
		return Calificacion.builder()
				.calLetra(dto.getCalLetra())
				.calNumericaDesde(dto.getCalNumericaDesde())
				.calNumericaHasta(dto.getCalNumericaHasta())
				.gradoCumplimiento(dto.getGradoCumplimiento())
				.valPorcentajeDesde(dto.getValPorcentajeDesde())
				.valPorcentajeHasta(dto.getValPorcentajeHasta())
				.id(dto.getId())
				.proceso(proceso)
				.build();
	}

	public static CalificacionDTO mapearDTO(Calificacion entidad) {
		return CalificacionDTO.builder()
				.calLetra(entidad.getCalLetra())
				.calNumericaDesde(entidad.getCalNumericaDesde())
				.calNumericaHasta(entidad.getCalNumericaHasta())
				.gradoCumplimiento(entidad.getGradoCumplimiento())
				.idProceso(entidad.getProceso().getId())
				.valPorcentajeHasta(entidad.getValPorcentajeHasta())
				.valPorcentajeDesde(entidad.getValPorcentajeDesde())
				.id(entidad.getId())
				.build();
	}

	public static CalificacionReporte mapearEntidadCalReporte(Calificacion entidad) {
		return CalificacionReporte.builder()
				.calNoNumerica(entidad.getCalLetra())
				.calNumericaDesde(entidad.getCalNumericaDesde())
				.calNumericaHasta(entidad.getCalNumericaHasta())
				.gradoCumplimiento(entidad.getGradoCumplimiento())
				.calPorcentajeDesde(entidad.getValPorcentajeDesde())
				.calPorcentajeHasta(entidad.getValPorcentajeHasta())
				.build();
	}
}
