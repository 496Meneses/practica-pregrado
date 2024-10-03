package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.dto.programa.ListarProgramaResponse;
import com.unicauca.procesos.dto.programa.ProgramaResponse;
import com.unicauca.procesos.mapper.ProgramaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.dto.programa.ProgramaRequest;
import com.unicauca.procesos.repository.ProgramaRepository;
import com.unicauca.procesos.service.ProgramaService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramaServiceImpl implements ProgramaService {

	@Autowired
	private ProgramaRepository programaRepository;

	@Override
	public Page<ListarProgramaResponse> listar(int pageNumber, int pageSize) {
		Page<Programa> page = this.programaRepository.findAll(PageRequest.of(pageNumber, pageSize));
		return page.map(ProgramaMapper :: mapearRespuestaLista);
	}

	@Override
	public Integer numeroProgramas() {
		return programaRepository.numeroProgramas();
	}

	@Override
	public ResponseEntity<Object> crearPrograma(ProgramaRequest programa) {
		try {
			Programa entidad = ProgramaMapper.mapearEntidad(programa);
			return ResponseEntity.status(HttpStatus.CREATED).body(ProgramaMapper.mapearRespuesta(this.programaRepository.save(entidad)));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error guardando programa: " + e);
		}
	}

	@Override
	public ResponseEntity<Object> buscarPorId(Long id) {
		try {
			Programa programa = this.programaRepository.getById(id);
			if (null != programa.getId()) {
				return ResponseEntity.status(HttpStatus.OK).body(ProgramaMapper.mapearRespuesta(programa));
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error buscar programa: " + e);
		}
	}

	@Override
	public ResponseEntity<Object> eliminarPrograma(Long id) {
		try {
			this.programaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Programa eliminado : " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error eliminar programa: " + e);
		}
	}

	@Override
	public List<ProgramaResponse> listarProgramasCatalogo() {
		return  this.programaRepository.findAll().stream().map(ProgramaMapper::mapearRespuesta).collect(Collectors.toList());
	}

}
