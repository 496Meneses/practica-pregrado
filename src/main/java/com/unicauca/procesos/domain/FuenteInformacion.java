package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.TipoFuente;
import com.unicauca.procesos.domain.catalogos.TipoPublico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_fuente_informacion")
public class FuenteInformacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "id_fuente_info_public")
	private TipoPublico tipoPublico;
	@ManyToOne
	@JoinColumn(name = "id_tipo_fuente_info")
	private TipoFuente tipoFuente;
	@OneToMany(mappedBy = "fuenteInformacion")
	private List<Archivo> archivos;
	@ManyToOne
	@JoinColumn(name = "id_proceso")
	private Proceso proceso;
	@Column(name = "documental")
	private Boolean documental;
}
