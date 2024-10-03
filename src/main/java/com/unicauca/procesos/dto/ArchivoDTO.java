package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ArchivoDTO implements Serializable {
	private Long id;
	private String nombre;
	private String link;
	private Long idFuenteInformacion;
	private Long nroAnexo;
}
