package com.unicauca.procesos.dto.proceso;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class BandejaProceso implements Serializable {
	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	private Boolean activo;
	private String estado;
}
