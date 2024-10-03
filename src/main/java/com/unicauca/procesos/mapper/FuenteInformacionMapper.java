package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.CronogramaActividad;
import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.domain.catalogos.TipoFuente;
import com.unicauca.procesos.domain.catalogos.TipoPublico;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesDTO;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteDocumentalReporte;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteNoDocumentalReporte;

import java.util.stream.Collectors;

public class FuenteInformacionMapper {
	private FuenteInformacionMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static FuenteInformacion mapearEntidad(FuenteInformacionDTO dto) {
		TipoFuente fuente = new TipoFuente();
		TipoPublico publico = new TipoPublico();
		Proceso proceso = new Proceso();
		proceso.setId(dto.getIdProceso());
		fuente.setId(dto.getIdTipoFuente());
		if (null != dto.getIdTipoPublico()) {
			publico.setId(dto.getIdTipoPublico());
		} else {
			publico = null;
		}
		return FuenteInformacion.builder().tipoFuente(fuente)
				.id(dto.getId())
				.proceso(proceso)
				.tipoPublico(publico)
				.archivos(dto.getArchivos().stream().map(ArchivoMapper::mapearEntidad).collect(Collectors.toList()))
				.descripcion(dto.getDescripcion())
				.documental(dto.getDocumental())
				.build();
	}

	public static FuenteInformacionDTO mapearDTO(FuenteInformacion entidad) {
		return FuenteInformacionDTO.builder()
				.id(entidad.getId())
				.desTipoFuente(entidad.getTipoFuente().getDescripcion())
				.idProceso(entidad.getProceso().getId())
				.idTipoFuente(entidad.getTipoFuente().getId())
				.desTipoPublico(entidad.getTipoPublico() != null ? entidad.getTipoPublico().getDescripcion():null)
				.idTipoPublico(entidad.getTipoPublico() != null ? entidad.getTipoPublico().getId(): null)
				.archivos(entidad.getArchivos().stream().map(ArchivoMapper::mapearDTO).collect(Collectors.toList()))
				.descripcion(entidad.getDescripcion())
				.documental(entidad.getDocumental())
				.build();
	}

	public static FuenteDocumentalReporte mapearFuenteDocumental(FuenteInformacion entidad) {
		return FuenteDocumentalReporte.builder()
				.descripcion(entidad.getDescripcion())
				.tipoFuente(entidad.getTipoFuente().getDescripcion())
				.build();
	}
	public static FuenteNoDocumentalReporte mapearFuenteNoDocumental(FuenteInformacion entidad) {
		return FuenteNoDocumentalReporte.builder()
				.descripcion(entidad.getDescripcion())
				.tipoFuente(entidad.getTipoFuente().getDescripcion())
				.tipoPublico(entidad.getTipoPublico().getDescripcion())
				.build();
	}
}
