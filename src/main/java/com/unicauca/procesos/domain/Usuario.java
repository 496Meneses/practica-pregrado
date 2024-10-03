package com.unicauca.procesos.domain;

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
@Table(name = "tbl_usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "correo")
	private String correo;
	@Column(name = "password")
	private String password;
	@ManyToOne
	@JoinColumn(name = "id_programa")
	private Programa programa;
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
}
