package com.unicauca.procesos.dto.programa;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ProgramaRequest {
	private String nombrePrograma;
	private Integer nroAspirantes;
	private Integer nroEstudiantesNuevosSemestre;
	private Integer nroEgresados;
	private Integer nroTotalDeEstudiantes;
	private Integer TS;
	private Integer nroProfesoresPlanta;
	private Integer nroProfesoresOcasionalesTiempoCompleto;
	private Integer nroProfesoresOcasionalesMedioTiempo;
	private Integer nroProfesoresCatedra;
	private Integer TEP;
	private Integer creditosAcademicosSinRequisitoCRS;
	private Integer creditosElectivosCE;
	private Integer creditosSuceptiblesHomologacionPorResolucion;
	private Integer modalidaesDeTrabajoDeGradoMG;
	private Integer totalCreditos;
	private Integer TI;
	private Long idNivelDeFormacion;
	private String resenaHistorica;
	private String infraestructuraPrograma;
	private String informaticosYAudiovisuales;
	private String recursosBibliograficos;
	private String bibliotecasFacultad;
	private String bibliotecasUniversidad;
	private Long idPrograma;
	private LocalDate fechaActualizacion;
	private String metodologia;
	private String objetivos;
	private BigDecimal alfa;
	private BigDecimal beta;
	private BigDecimal gamma;
	private BigDecimal delta;
	private String justificacionEvaluacion;
}
