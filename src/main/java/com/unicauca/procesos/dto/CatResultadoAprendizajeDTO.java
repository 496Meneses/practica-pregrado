package com.unicauca.procesos.dto;

import com.unicauca.procesos.domain.Programa;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
public class CatResultadoAprendizajeDTO implements Serializable {
	private Long id; // id del catalogo
	private String descripcion;
	private Boolean cumplimiento;
	private Long idResultadoDeAprendizaje; // id del resultado aprendizaje
	private Long idPrograma;
	private String codigo;
	private Programa programa;
	private Long idProceso;
}
