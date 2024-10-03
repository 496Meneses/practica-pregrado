package com.unicauca.procesos.dto.asignatura;

import com.unicauca.procesos.domain.AsignaturaSemestre;
import com.unicauca.procesos.domain.PlanEstudio;
import com.unicauca.procesos.domain.catalogos.TipoAsignatura;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AsignaturaDto implements Serializable {
	private Long id;
	private String nombre;
	private Integer creditos;
	private Integer docenciaDirectaPractica;
	private Integer docenciaDirectaTeorica;
	private Integer docenciaIndPractica;
	private Integer docenciaIndTeorica;
	private String areaFormacion;
	private TipoAsignatura tipoAsignatura;
	private AsignaturaSemestre asignaturaSemestre;
	private PlanEstudio planEstudio;
	private Long idPlanEstudio;
	private Integer pageNumber;
	private Integer pageSize;
}
