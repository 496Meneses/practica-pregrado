package com.unicauca.procesos.dto;

import com.unicauca.procesos.domain.catalogos.Cargo;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponsablePlanMejoramientoDTO implements Serializable {
	private Long id;
	private String nombreResponsable;
	private Long idCargo;
	private String desCargo;
	private String dependencia;
	private Long idPrograma;
	private String telefono;
	private String correo;
	private Long idProceso;
}
