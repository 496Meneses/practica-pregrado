package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponsableAcreditacionDTO implements Serializable {
	private Long id;
	private Long idPrograma;
	private Long idCargo;
	private String telefono;
	private String nombre;
	private String correo;
	private String descripcionCargo;
	private Long idProceso;
}
