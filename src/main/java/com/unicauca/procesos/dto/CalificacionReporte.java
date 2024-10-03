package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CalificacionReporte implements Serializable {
	private String gradoCumplimiento;
	private String calNoNumerica;
	private BigDecimal calNumericaDesde;
	private BigDecimal calNumericaHasta;
	private BigDecimal calPorcentajeDesde;
	private BigDecimal calPorcentajeHasta;
}
