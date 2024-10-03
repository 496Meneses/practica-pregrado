package com.unicauca.procesos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_programa_academico")
public class Programa implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "est_numero_aspirantes")
	private Integer estNumeroAspirantes;
	@Column(name = "est_total_estudiantes")
	private Integer nroTotalDeEstudiantes;

	@Column(name = "est_nro_estudiantes")
	private Integer estNumeroEstudiantes;

	@Column(name = "est_nro_egresados")
	private Integer estNumeroEgresados;

	@Column(name = "prof_nro_planta")
	private Integer profNumeroPlanta;

	@Column(name = "prof_nro_ocasionales_tc")
	private Integer profNumeroOcasionalesTc;

	@Column(name = "prof_nro_ocasionales_mt")
	private Integer profNroOcacionalesMt;

	@Column(name = "prof_nro_catedra")
	private Integer profNumeroCatedra;

	@Column(name = "nro_creditos_sin_csr")
	private Integer numeroCredtiosSinCsr;
	@Column(name = "nro_creditos_electivos_ce")
	private Integer numeroCreditosElectivosCe;
	@Column(name = "nro_creditos_susceptibles")
	private Integer numeroCreditosSuceptibles;
	@Column(name = "nro_modalidades_mg")
	private Integer numeroModalidadesMg;
	@Column(name = "total_creditos")
	private Integer totalCreditos;
	@Column(name = "resena_historica")
	private String resenaHistorica;
	@Column(name = "recursos_infraestructura")
	private String recursosInfraestructura;
	@Column(name = "recursos_info_audiovisuales")
	private String recursosAudiovisuales;
	@Column(name = "recursos_bibliograficos")
	private String recursosBibiliograficos;
	@Column(name = "recursos_bibliotecas_facultad")
	private String recursosBibliotecasFacultad;
	@Column(name = "recursos_bibliotecas_universidad")
	private String recursosBibliotecasUniversidad;
	@Column(name = "apreciacion_global_factores")
	private String apreciacionGlobalFactores;
	@Column(name = "id_nivel_formacion")
	private Long idNivelFormacion;
	@Column(name = "id_escala_calificacion")
	private Long idEscalaClasificacion;
	@Column(name = "fecha_actualizacion")
	private LocalDate fechaActualizacion;
	@Column(name = "metodologia")
	private String metodologia;
	@Column(name = "objetivos")
	private String objetivos;
	@Column(name = "alfa")
	private BigDecimal alfa;
	@Column(name = "beta")
	private BigDecimal beta;
	@Column(name = "gamma")
	private BigDecimal gamma;
	@Column(name = "delta")
	private BigDecimal delta;
}
