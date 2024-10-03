package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class AspectoDTO implements Serializable {
	private String aspecto;
	private BigDecimal ponderacion;
	private BigDecimal calificacion;
	private BigDecimal evaluacion;
}
