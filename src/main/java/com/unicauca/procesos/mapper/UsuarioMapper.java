package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.*;
import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.UsuarioDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioMapper {
	private UsuarioMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }
	public static Usuario mapearEntidad(UsuarioDTO dto) {
		Programa programa = new Programa();
		Rol rol = new Rol();
		if (dto.getIdPrograma() != null) {
			programa.setId(dto.getIdPrograma());
		}
		if (dto.getIdRol() != null) {
			rol.setId(dto.getIdRol());
		}
		Usuario a = Usuario.builder()
				.id(dto.getId())
				.correo(dto.getCorreo())
				.programa(dto.getIdPrograma() != null ? programa : null)
				.rol(dto.getIdRol() != null ? rol : null)
				.password(new BCryptPasswordEncoder().encode(dto.getPassword()))
				.build();
		return a;
	}
	public static UsuarioDTO mapearDTO(Usuario entidad) {
		return UsuarioDTO.builder()
				.correo(entidad.getCorreo())
				.id(entidad.getId())
				.idPrograma(entidad.getPrograma() != null ? entidad.getPrograma().getId() : null)
				.desPrograma(entidad.getPrograma() != null ? entidad.getPrograma().getNombre() : null)
				.idRol(entidad.getRol() != null ? entidad.getRol().getId() : null)
				.desRol(entidad.getRol() != null ? entidad.getRol().getDescripcion() : null)
				.build();
	}
}
