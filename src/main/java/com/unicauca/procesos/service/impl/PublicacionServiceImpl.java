package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Publicacion;
import com.unicauca.procesos.dto.publicacion.ListaPublicacionResponse;
import com.unicauca.procesos.dto.publicacion.PublicacionRequest;
import com.unicauca.procesos.dto.publicacion.PublicacionResponse;
import com.unicauca.procesos.mapper.PublicacionMapper;
import com.unicauca.procesos.repository.PublicacionRepository;
import com.unicauca.procesos.service.PublicacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class PublicacionServiceImpl implements PublicacionService {

	@Autowired
	private PublicacionRepository publicacionRepository;

	@Override
	public PublicacionResponse crear(PublicacionRequest publicacionRequest) {
		Publicacion publicacion = PublicacionMapper.mapearEntidad(publicacionRequest);
		publicacion = this.publicacionRepository.save(publicacion);
		if (publicacion != null) {
			return PublicacionMapper.mapearRespuesta(publicacion);
		}
		return null;
	}

	@Override
	public PublicacionResponse editar(PublicacionRequest publicacion) {
		return this.crear(publicacion);
	}

	@Override
	public PublicacionResponse eliminar(Long id) {
		//VALIDAR SI SE PUEDE ELIMINAR LA PUBLICACION y RESPONDER
		this.publicacionRepository.deleteById(id);
		return null;
	}

	@Override
	public Page<ListaPublicacionResponse> listar(int pageNumber, int pageSize) {
		Page<Publicacion> paginas = this.publicacionRepository.findAll(PageRequest.of(pageNumber - 1, pageSize));
		return paginas.map(PublicacionMapper::mapearLista);
	}

	@Override
	public PublicacionResponse consultar(Long id) {
		return PublicacionMapper.mapearRespuesta(publicacionRepository.findById(id).get());
	}
}
