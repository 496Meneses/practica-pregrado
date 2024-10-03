package com.unicauca.procesos.service.impl;

import com.unicauca.procesos.domain.Archivo;
import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteInformacionDTO;
import com.unicauca.procesos.mapper.ArchivoMapper;
import com.unicauca.procesos.mapper.FuenteInformacionMapper;
import com.unicauca.procesos.repository.ArchivoRepository;
import com.unicauca.procesos.repository.FuenteInformacionRepository;
import com.unicauca.procesos.service.FuenteInformacionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuenteInformacionServiceImpl implements FuenteInformacionService {

	@Autowired
	private FuenteInformacionRepository fuenteInformacionRepository;
	@Autowired
	private ArchivoRepository archivoRepository;
	@Override
	public FuenteInformacionDTO crear(FuenteInformacionDTO dto) {
		FuenteInformacion fuente;
		fuente = FuenteInformacionMapper.mapearEntidad(dto);
		List<Archivo> archivos = dto.getArchivos().stream().map(ArchivoMapper::mapearEntidad).collect(Collectors.toList());
		fuente = this.fuenteInformacionRepository.save(fuente);
		this.guardarArchivos(archivos, dto.getIdProceso(), fuente.getId());
		if (null != fuente.getId()) {
			FuenteInformacionDTO dtoFuente = FuenteInformacionMapper.mapearDTO(fuente);
			dtoFuente.setArchivos(fuente.getArchivos().stream().map(ArchivoMapper::mapearDTO).collect(Collectors.toList()));
			return dtoFuente;
		}
		return null;
	}

	private List<Archivo> guardarArchivos(List<Archivo> archivos, Long idProceso, Long idFuente) {
		Long contador = contarNumeroDeAnexosDelProceso(idProceso);
		if (contador == 0) {
			contador++;
		}
		for (Archivo archivo: archivos) {
			archivo.setNroAnexo(contador);
			archivo.setFuenteInformacion(this.fuenteInformacionRepository.findById(idFuente).get());
			contador++;
			this.archivoRepository.save(archivo);
		}
		return archivos;
	}

	@Override
	public List<FuenteInformacionDTO> listarFuentesDocumentales(Long idProceso, boolean documental) {
		return this.fuenteInformacionRepository.findByProcesoIdAndDocumental(idProceso, documental).stream().map(FuenteInformacionMapper::mapearDTO).collect(Collectors.toList());
	}

	@Override
	public Boolean eliminarFuenteInformacion(Long idFuente) {
		FuenteInformacion fuente = this.fuenteInformacionRepository.findById(idFuente).get();
		if (null == fuente) {
			return false;
		}
		this.elimiarArchivos(fuente.getArchivos());
		fuente.setArchivos(null);
		this.fuenteInformacionRepository.deleteById(fuente.getId());
		return true;
	}
	private boolean elimiarArchivos(final List<Archivo> archivos) {
		for (Archivo archivoE: archivos) {
			this.archivoRepository.deleteById(archivoE.getId());
		}
		return true;
	}

	private Long contarNumeroDeAnexosDelProceso(final Long idProceso) {
		List<FuenteInformacion> fuentesInformacion = this.fuenteInformacionRepository.findByProcesoId(idProceso);
		Long contador = 0L;
		for (FuenteInformacion fuente: fuentesInformacion) {
			if (fuente.getArchivos() == null) {
				continue;
			}
			contador = fuente.getArchivos().size() + contador;
		}
		return contador;
	}

	@Override
	public FuenteInformacionDTO consultarFuenteInformacionPorId(Long idFuente) {
		return null;
	}

	@Override
	public Boolean eliminarArchivoPorId(Long idArchivo) {
		this.archivoRepository.deleteById(idArchivo);
		return true;
	}
}
