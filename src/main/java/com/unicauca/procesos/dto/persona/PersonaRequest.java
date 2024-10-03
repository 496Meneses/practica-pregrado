package com.unicauca.procesos.dto.persona;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonaRequest {
	private Long id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String telefono;
}
