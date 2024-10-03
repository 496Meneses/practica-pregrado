package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_proceso")
public class Proceso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "fecha_finalizacion")
	private LocalDate fechaFinalizacion;
	@ManyToOne
	@JoinColumn(name = "id_programa")
	private Programa programa;
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	@Column(name = "activo")
	private Boolean activo;
	@Column(name = "justificacion_eval_programa")
	private String justificacionEvaluacion;

}
