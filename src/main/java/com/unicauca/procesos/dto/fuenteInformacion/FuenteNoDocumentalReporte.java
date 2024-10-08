package com.unicauca.procesos.dto.fuenteInformacion;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class FuenteNoDocumentalReporte implements Serializable {
	private String tipoFuente;
	private String tipoPublico;
	private String descripcion;
}
