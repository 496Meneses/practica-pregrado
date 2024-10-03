package com.unicauca.procesos.mapper;

import com.unicauca.procesos.domain.Persona;
import com.unicauca.procesos.dto.persona.PersonaRequest;
import com.unicauca.procesos.dto.persona.PersonaResponse;

public final class PersonaMapper {
	public static Persona mapearEntidad(PersonaRequest personaRequest) {
		return Persona.builder().nombres(personaRequest.getNombres())
				.apellidos(personaRequest.getApellidos())
				.correo(personaRequest.getCorreo())
				.telefono(personaRequest.getTelefono()).build();
	}
	public static PersonaResponse mapearRequestDesdeEntidad(Persona persona) {
		return PersonaResponse.builder().id(persona.getId()).build();
	}

	public static Persona crearPersona(String nombres, String apellidos) {
		return Persona.builder().nombres(nombres)
				.apellidos(apellidos)
				.build();
	}
}
