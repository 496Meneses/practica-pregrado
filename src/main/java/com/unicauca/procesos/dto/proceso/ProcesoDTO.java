package com.unicauca.procesos.dto.proceso;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class ProcesoDTO implements Serializable {
	private Long id;
	private Long idPrograma;
	private Boolean activo;
	private String estado;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String justificacionEvaluacion;
}
