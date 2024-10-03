package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Archivo;
import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.domain.ResultadoAprendizaje;
import com.unicauca.procesos.domain.catalogos.CatResultadoAprendizaje;
import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.CatResultadoAprendizajeDTO;

public class CatResultadoAprendizajeMapper {
	private CatResultadoAprendizajeMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }
	public static CatResultadoAprendizajeDTO mapearDTO(CatResultadoAprendizaje entidad, ResultadoAprendizaje resultadoAprendizaje) {
		return CatResultadoAprendizajeDTO.builder()
				.id(entidad.getId())
				.idResultadoDeAprendizaje(resultadoAprendizaje.getId())
				.cumplimiento(resultadoAprendizaje.getCumplimiento())
				.descripcion(entidad.getDescripcion())
				.codigo(entidad.getCodigo())
				.idPrograma(resultadoAprendizaje.getPrograma().getId())
				.programa(resultadoAprendizaje.getPrograma())
				.build();
	}
}
