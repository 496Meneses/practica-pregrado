package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class CumplimientoRADTO implements Serializable {
	private List<CatResultadoAprendizajeDTO> resultadoAprendizaje;
	private Long idAsignatura;
	private Long idDocente;
	private Long idPrograma; // programa al que pertenecen los resultados de aprendizaje
	private String desAsignatura;
	private String desDocente;
	private Boolean notificarCambio;
	private Long idProceso;
}
