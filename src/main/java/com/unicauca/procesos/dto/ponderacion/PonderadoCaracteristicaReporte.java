package com.unicauca.procesos.dto.ponderacion;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class PonderadoCaracteristicaReporte implements Serializable {
	private String nombre;
	private BigDecimal ponderado;
	private String justificacion;
	private String factor;
}
