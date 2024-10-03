package com.unicauca.procesos.dto.publicacion;

import com.unicauca.procesos.domain.catalogos.TipoPublicacion;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PublicacionResponse {
	private Long id;
	private String referenciaBibliografica;
	private LocalDate fechaPublicacion;
	private TipoPublicacion tipoPublicacion;
	private Boolean activo;
}
