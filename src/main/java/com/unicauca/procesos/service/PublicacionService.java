package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.publicacion.ListaPublicacionResponse;
import com.unicauca.procesos.dto.publicacion.PublicacionRequest;
import com.unicauca.procesos.dto.publicacion.PublicacionResponse;
import org.springframework.data.domain.Page;

public interface PublicacionService {
	PublicacionResponse crear(final PublicacionRequest publicacion);
	PublicacionResponse editar(final PublicacionRequest publicacion);
	PublicacionResponse eliminar(final Long id);
	Page<ListaPublicacionResponse> listar(final int pageNumber, final int pageSize);
	PublicacionResponse consultar(final Long id);
}
