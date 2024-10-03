package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Usuario;
import com.unicauca.procesos.dto.ArchivoDTO;
import com.unicauca.procesos.dto.UsuarioDTO;
import com.unicauca.procesos.mapper.ArchivoMapper;
import com.unicauca.procesos.mapper.UsuarioMapper;
import com.unicauca.procesos.repository.ArchivoRepository;
import com.unicauca.procesos.repository.UsuarioRepository;
import com.unicauca.procesos.service.ArchivoService;
import com.unicauca.procesos.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;


	@Override
	public UsuarioDTO obtenerDetallePorCorreo(String correo) {
		Usuario usuario = usuarioRepository.findByCorreo(correo).get();
		if (usuario != null) {
			return UsuarioMapper.mapearDTO(usuario);
		}
		return null;

	}

	@Override
	public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario resultado = this.usuarioRepository.save(UsuarioMapper.mapearEntidad(usuarioDTO));
		if (resultado != null) {
			return UsuarioMapper.mapearDTO(resultado);
		}
		return null;
	}

	@Override
	public List<UsuarioDTO> listarUsuarios() {
		return this.usuarioRepository.findAll().stream().map(UsuarioMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean eliminarUsuario(Long id) {
		this.usuarioRepository.deleteById(id);
		return true;
	}
}
