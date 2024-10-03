package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.Cargo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_responsable_plan_mejoramiento")
public class ResponsablePlanMejoramiento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre_responsable")
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	@ManyToOne
	@JoinColumn(name =  "id_programa")
	private Programa programa;
	@Column(name = "dependencia")
	private String dependencia;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "correo")
	private String correo;
	@ManyToOne
	@JoinColumn(name =  "id_proceso")
	private Proceso proceso;
}
