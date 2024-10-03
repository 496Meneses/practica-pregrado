package com.unicauca.procesos.dto.programa;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ListarProgramaResponse {
	private String nombre;
	private Long idNivelFormacion;
	private String resenaHistorica;
	private LocalDate fechaActualizacion;
	private Integer nroTotalDeEstudiantes;
	private Long id;
}
