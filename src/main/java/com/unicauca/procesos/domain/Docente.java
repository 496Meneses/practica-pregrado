package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.Escalafon;
import com.unicauca.procesos.domain.catalogos.TipoDeVinculacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_docente")
public class Docente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titulos_pregrado")
	private String titulosPregrado;
	@Column(name = "titulos_posgrado")
	private String titulosPosgrado;
	@Column(name = "anios_experiencia_docente")
	private Integer aniosExperenciaDocente;
	@Column(name = "anios_experiencia_laboral")
	private Integer aniosExperienciaLaboral;
	@Column(name = "experticia")
	private String experticia;
	@OneToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;
	@ManyToOne
	@JoinColumn(name = "id_vinculacion")
	private TipoDeVinculacion vinculacion;
	@ManyToOne
	@JoinColumn(name = "id_escalafon")
	private Escalafon escalafon;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tbl_docente_publicacion",
			joinColumns = @JoinColumn(name = "id_docente"),
			inverseJoinColumns = @JoinColumn(name = "id_publicacion"))
	private List<Publicacion> publicaciones;
	@ManyToOne
	@JoinColumn(name = "id_programa")
	private Programa programa;
}
