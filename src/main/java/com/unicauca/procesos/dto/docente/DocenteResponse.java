package com.unicauca.procesos.dto.docente;

import com.unicauca.procesos.dto.persona.PersonaResponse;
import com.unicauca.procesos.dto.publicacion.PublicacionResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DocenteResponse {
	private Long id;
	private String titulosPregrado;
	private String titulosPosgrado;
	private Integer aniosExperienciaDocente;
	private Integer aniosExperienciaLaboral;
	private String experticia;
	private Long idVinculacion;
	private Long idEscalafon;
	private PersonaResponse persona;
	private List<PublicacionResponse> publicaciones;
	private Long idPrograma;
}
