package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_ponderacion")
public class Ponderacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "ponderado")
	private BigDecimal ponderado;
	@Column(name = "justificacion")
	private String justificacion;
	@Column(name = "justificacion_evaluacion")
	private String justificacionEvaluacion;
	@Column(name = "calificacion")
	private BigDecimal calificacion;
	@Column(name = "evaluacion")
	private BigDecimal evaluacion;
	@Column(name = "fortalezas")
	private String fortalezas;
	@Column(name = "debilidades")
	private String debilidades;
	@ManyToOne
	@JoinColumn(name = "id_factor")
	private Factor factor;
	@ManyToOne
	@JoinColumn(name = "id_caracteristica")
	private Caracteristica caracteristica;
	@ManyToOne
	@JoinColumn(name = "id_proceso")
	private Proceso proceso;
	@ManyToOne
	@JoinColumn(name = "id_aspecto")
	private Aspecto aspecto;
}
