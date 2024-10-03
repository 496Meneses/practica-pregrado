package com.unicauca.procesos.mapper;

import com.unicauca.procesos.domain.Publicacion;
import com.unicauca.procesos.domain.catalogos.TipoPublicacion;
import com.unicauca.procesos.dto.publicacion.ListaPublicacionResponse;
import com.unicauca.procesos.dto.publicacion.PublicacionRequest;
import com.unicauca.procesos.dto.publicacion.PublicacionResponse;

public class PublicacionMapper {
	public static Publicacion mapearEntidad(PublicacionRequest publicaicon) {
		return Publicacion.builder().idPublicacionTipo(publicaicon.getTipoPublicacion().getId())
				.id(publicaicon.getId())
				.fechaPublicacion(publicaicon.getFechaPublicacion())
				.referenciaBibliografica(publicaicon.getReferenciaBibliografica())
				.activo(publicaicon.getActivo())
				.build();
	}
	public static PublicacionResponse mapearRespuesta(Publicacion publicacion) {
		return PublicacionResponse.builder().id(publicacion.getId())
				.tipoPublicacion(TipoPublicacion.builder().id(publicacion.getIdPublicacionTipo()).build())
				.fechaPublicacion(publicacion.getFechaPublicacion())
				.referenciaBibliografica(publicacion.getReferenciaBibliografica())
				.activo(publicacion.getActivo())
				.build();
	}
	public static ListaPublicacionResponse mapearLista(Publicacion publicacion) {
		return ListaPublicacionResponse.builder().fechaPublicacion(publicacion.getFechaPublicacion())
				.idTipoPublicacion(publicacion.getIdPublicacionTipo())
				.id(publicacion.getId())
				.referenciaBibliografica(publicacion.getReferenciaBibliografica()).build();
	}
}
