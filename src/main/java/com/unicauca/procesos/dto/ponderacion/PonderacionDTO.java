package com.unicauca.procesos.dto.ponderacion;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class PonderacionDTO implements Serializable {
	private Long id;
	private BigDecimal ponderado;
	private String justificacion;
	private Long idFactor;
	private String desFactor;
	private Long idCaracteristica;
	private String desCaracteristica;
	private Long idAspecto;
	private String desAspecto;
	private Long idProceso;
	private BigDecimal calificacion;
	private BigDecimal evaluacion;
	private String fortalezas;
	private String debilidades;
	private String justificacionEvaluacion;
	private String calificacionNoNumerica;
	private String gradoCumplimientoNoNumerica;
}
