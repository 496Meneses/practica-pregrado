package com.unicauca.procesos.dto.comite;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ComiteReporte implements Serializable {
	private String nombreIntegrante;
	private String cargo;
}
