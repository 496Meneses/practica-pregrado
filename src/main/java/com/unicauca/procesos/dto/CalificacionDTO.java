package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CalificacionDTO implements Serializable {
	private Long id;
	private String gradoCumplimiento;
	private String calLetra;
	private BigDecimal calNumericaDesde;
	private BigDecimal calNumericaHasta;
	private BigDecimal valPorcentajeDesde;
	private BigDecimal valPorcentajeHasta;
	private Long idProceso;
}
