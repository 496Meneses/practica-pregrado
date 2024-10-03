package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
	UsuarioDTO obtenerDetallePorCorreo(String correo);
	UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);
	List<UsuarioDTO> listarUsuarios();

	Boolean eliminarUsuario(Long id);
}
