package com.unicauca.procesos.dto.publicacion;

import com.unicauca.procesos.domain.catalogos.TipoPublicacion;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PublicacionRequest {
	private Long id;
	private String referenciaBibliografica;
	private TipoPublicacion tipoPublicacion;
	private LocalDate fechaPublicacion;
	private Boolean activo;
}
