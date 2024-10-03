package com.unicauca.procesos.dto.docente;

import com.unicauca.procesos.dto.persona.PersonaResponse;
import com.unicauca.procesos.dto.publicacion.PublicacionResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DocenteReporte {
	private String nombres;
	private String apellidos;
	private String tipoDeVinculacion;
	private String escalafon;
	private String anosExpDocente;
	private String aniosExperienciaProfesional;
}
