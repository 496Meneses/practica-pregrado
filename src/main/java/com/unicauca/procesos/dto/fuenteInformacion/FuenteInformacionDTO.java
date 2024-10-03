package com.unicauca.procesos.dto.fuenteInformacion;

import com.unicauca.procesos.domain.Archivo;
import com.unicauca.procesos.dto.ArchivoDTO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class FuenteInformacionDTO implements Serializable {
	private Long id;
	private String descripcion;
	private Long idTipoPublico;
	private String desTipoPublico;
	private Long idTipoFuente;
	private String desTipoFuente;
	private Long idProceso;
	private List<ArchivoDTO> archivos;
	private Boolean documental;
}
