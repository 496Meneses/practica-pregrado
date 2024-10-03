package com.unicauca.procesos.dto.docente;

import com.unicauca.procesos.dto.persona.PersonaRequest;
import com.unicauca.procesos.dto.publicacion.PublicacionRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DocenteRequest {
	private Long id;
	private String nombres;
	private String apellidos;
	private String titulosPregrado;
	private String titulosPosgrado;
	private Integer aniosExperienciaDocente;
	private Integer aniosExperienciaLaboral;
	private String experticia;
	private Long idVinculacion;
	private Long idEscalafon;
	private List<PublicacionRequest> publicaciones;
	private PersonaRequest persona;
	private Long idPrograma;
}
