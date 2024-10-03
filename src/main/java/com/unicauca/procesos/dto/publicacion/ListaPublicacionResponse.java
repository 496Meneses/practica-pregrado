package com.unicauca.procesos.dto.publicacion;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class ListaPublicacionResponse {
	private Long id;
	private Long idTipoPublicacion;
	private LocalDate fechaPublicacion;
	private String referenciaBibliografica;
}
