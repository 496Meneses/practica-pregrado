package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Ponderacion;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.catalogos.Aspecto;
import com.unicauca.procesos.domain.catalogos.Caracteristica;
import com.unicauca.procesos.domain.catalogos.Factor;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionFactorReporte;
import com.unicauca.procesos.dto.ponderacion.PonderadoCaracteristicaReporte;
import com.unicauca.procesos.repository.ProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PonderacionMapper {
	private PonderacionMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	@Autowired
	private ProcesoRepository procesoRepository;

	public static Ponderacion mapearEntidad(PonderacionDTO dto) {
		Factor factor = new Factor();
		Proceso proceso = new Proceso();
		proceso.setId(dto.getIdProceso());
		Caracteristica caracteristica = new Caracteristica();
		Aspecto aspecto = new Aspecto();
		if (dto.getIdFactor() != null) {
			factor.setId(dto.getIdFactor());
		}
		if (dto.getIdCaracteristica() != null) {
			caracteristica.setId(dto.getIdCaracteristica());
		}
		if (dto.getIdAspecto() != null) {
			aspecto.setId(dto.getIdAspecto());
		}
		return Ponderacion.builder()
				.id(dto.getId())
				.factor(dto.getIdFactor() != null ? factor : null)
				.caracteristica(dto.getIdCaracteristica() != null ? caracteristica : null)
				.ponderado(dto.getPonderado())
				.justificacion(dto.getJustificacion())
				.proceso(proceso)
				.aspecto(dto.getIdAspecto() != null ? aspecto : null)
				.calificacion(dto.getCalificacion())
				.evaluacion(dto.getEvaluacion())
				.fortalezas(dto.getFortalezas())
				.debilidades(dto.getDebilidades())
				.justificacionEvaluacion(dto.getJustificacionEvaluacion())
				.build();
	}

	public static PonderacionDTO mapearDTO(Ponderacion entidad) {
		return PonderacionDTO.builder()
				.id(entidad.getId())
				.idCaracteristica(entidad.getCaracteristica() != null ? entidad.getCaracteristica().getId() : null)
				.idFactor(entidad.getFactor() != null ? entidad.getFactor().getId() : null)
				.justificacion(entidad.getJustificacion())
				.ponderado(entidad.getPonderado())
				.desFactor(entidad.getFactor() != null ? entidad.getFactor().getDescripcion() : null)
				.desCaracteristica(entidad.getCaracteristica() != null ? entidad.getCaracteristica().getDescripcion() : null)
				.idAspecto(entidad.getAspecto() != null ? entidad.getAspecto().getId() : null)
				.desAspecto(entidad.getAspecto() != null ? entidad.getAspecto().getDescripcion() : null)
				.evaluacion(entidad.getEvaluacion())
				.calificacion(entidad.getCalificacion())
				.idProceso(entidad.getProceso().getId())
				.fortalezas(entidad.getFortalezas())
				.debilidades(entidad.getDebilidades())
				.justificacionEvaluacion(entidad.getJustificacionEvaluacion())
				.calificacionNoNumerica("E") // todo AJUSTAR PRUEBA E
				.gradoCumplimientoNoNumerica("NO CUMPLE") // todo Ajustar Prueba
				.build();
	}

	public static PonderacionFactorReporte mapPonderadoFactor(Ponderacion entidad) {
		return PonderacionFactorReporte.
				builder()
				.nombre(entidad.getFactor().getNombre())
				.ponderado(entidad.getPonderado())
				.justificacion(entidad.getJustificacion())
				.build();
	}
	public static PonderadoCaracteristicaReporte mapPonderadoCaracteristica(Ponderacion entidad) {
		return PonderadoCaracteristicaReporte.
				builder()
				.nombre(entidad.getCaracteristica().getNombre())
				.ponderado(entidad.getPonderado())
				.factor(entidad.getFactor().getNombre())
				.justificacion(entidad.getJustificacion())
				.build();
	}
}
