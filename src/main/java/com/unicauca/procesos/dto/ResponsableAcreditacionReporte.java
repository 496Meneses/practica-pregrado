package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponsableAcreditacionReporte implements Serializable {
	private String nombreResponsable;
	private String cargo;
	private String dependenciaAdscrito;
	private String telefono;
	private String email;
}
