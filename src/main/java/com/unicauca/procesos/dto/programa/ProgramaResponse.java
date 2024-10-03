package com.unicauca.procesos.dto.programa;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ProgramaResponse {
	private String nombrePrograma;
	private String nombre;
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
	private Long id; //TAMBIEN ES EL ID DEL PROGRAMA
	private String metodologia;
	private String objetivos;
	private LocalDate fechaActualizacion;
	private BigDecimal alfa;
	private BigDecimal beta;
	private BigDecimal gamma;
	private BigDecimal delta;
}
