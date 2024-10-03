package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.CatResultadoAprendizaje;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_resultado_aprendizaje")
public class ResultadoAprendizaje implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_asignatura")
	private Asignatura asignatura;
	@ManyToOne
	@JoinColumn(name = "id_docente")
	private Docente docente;
	@ManyToOne
	@JoinColumn(name = "id_cat_resultado_aprendizaje")
	private CatResultadoAprendizaje catResultadoAprendizaje;
	@ManyToOne
	@JoinColumn(name="id_programa")
	private Programa programa;
	@Column(name = "cumplimiento")
	private Boolean cumplimiento;
	@ManyToOne
	@JoinColumn(name = "id_proceso")
	private Proceso proceso;
}
