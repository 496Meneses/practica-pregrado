package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.TipoAsignatura;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_asignatura")
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name =  "nombre")
	private String nombre;
	@Column(name =  "creditos")
	private Integer creditos;
	@Column(name =  "docencia_directa_practica")
	private Integer docenciaDirectaPractica;
	@Column(name =  "docencia_directa_teorica")
	private Integer docenciaDirectaTeorica;
	@Column(name =  "docencia_ind_practica")
	private Integer docenciaIndPractica;
	@Column(name =  "docencia_ind_teorica")
	private Integer docenciaIndTeorica;
	@Column(name =  "area_formacion")
	private String areaFormacion;
	@ManyToOne
	@JoinColumn(name =  "id_tipo_asignatura")
	private TipoAsignatura tipoAsignatura;
	@ManyToOne
	@JoinColumn(name =  "id_asignatura_semestre")
	private AsignaturaSemestre asignaturaSemestre;
	@ManyToOne
	@JoinColumn(name =  "id_plan_estudio")
	private PlanEstudio planEstudio;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tbl_resultado_aprendizaje",
			joinColumns = @JoinColumn(name = "id_asignatura"),
			inverseJoinColumns = @JoinColumn(name = "id"))
	private List<ResultadoAprendizaje> resultadosAprendizaje;
}
