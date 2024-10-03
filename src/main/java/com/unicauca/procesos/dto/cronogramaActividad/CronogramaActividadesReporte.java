package com.unicauca.procesos.dto.cronogramaActividad;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class CronogramaActividadesReporte implements Serializable {
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
}
