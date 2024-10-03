package com.unicauca.procesos.dto.comite;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ComiteDTO implements Serializable {
	private Long idComite;
	private String nombreCompleto;
	private Long idCargo;
	private Long idPrograma;
	private String descripcionCargo;
	private Long idProceso;
}
