package com.unicauca.procesos.dto.docente;

import com.unicauca.procesos.domain.catalogos.Escalafon;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DocenteListaResponse {
	private Long id;
	private String nombres;
	private String apellidos;
	private Long idEscalafon;
	private Long idPrograma;
	private String desPrograma;
}
