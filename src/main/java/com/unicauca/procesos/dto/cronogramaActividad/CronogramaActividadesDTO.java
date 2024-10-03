package com.unicauca.procesos.dto.cronogramaActividad;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class CronogramaActividadesDTO implements Serializable {
	private Long id;
	private Long idPrograma;
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Long idProceso;
}
