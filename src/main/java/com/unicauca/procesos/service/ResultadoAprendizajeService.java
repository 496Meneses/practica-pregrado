package com.unicauca.procesos.service;

import com.unicauca.procesos.domain.catalogos.CatResultadoAprendizaje;
import com.unicauca.procesos.dto.CatResultadoAprendizajeDTO;
import com.unicauca.procesos.dto.CumplimientoRADTO;
import com.unicauca.procesos.dto.comite.ComiteDTO;
import com.unicauca.procesos.dto.programa.ListarProgramaResponse;
import com.unicauca.procesos.dto.programa.ProgramaRequest;
import com.unicauca.procesos.dto.programa.ProgramaResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResultadoAprendizajeService {


	CumplimientoRADTO crearCumplimientoAsignatura(CumplimientoRADTO dto);
	List<CumplimientoRADTO> crearListaCumplimientoAsignatura(List<CumplimientoRADTO> dto);

	CumplimientoRADTO crearCumplimientoDocente(CumplimientoRADTO dto);

	List<CumplimientoRADTO> listarCumplimientoAsignatura(Long idPrograma, Long idProceso);

	List<CumplimientoRADTO> listarCumplimientoDocente(Long idPrograma);

	CatResultadoAprendizajeDTO crearCatResultadoAprendizaje(CatResultadoAprendizajeDTO dto);

	List<CatResultadoAprendizajeDTO> crearListaCatResultadoAprendizaje(List<CatResultadoAprendizajeDTO> dto);

	boolean eliminarCatResultadoAprendizaje(Long idCatResultadoAprendizaje);

	List<CumplimientoRADTO> crearListaCumplimientoDocente(List<CumplimientoRADTO> dtos);
}
