package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.Cargo;
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
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_responsable_acreditacion")
public class ResponsableAcreditacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre_responsable")
	private String nombre;
	@Column(name = "telefono_responsable")
	private String telefono;
	@Column(name = "correo_responsable")
	private String correo;
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;
	@ManyToOne
	@JoinColumn(name="id_programa")
	private Programa programa;
	@ManyToOne
	@JoinColumn(name="id_proceso")
	private Proceso proceso;
}
