package com.unicauca.procesos.domain.catalogos;

import com.unicauca.procesos.domain.Proceso;
import com.unicauca.procesos.domain.Programa;
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
import javax.persistence.Table;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cat_resultado_aprendizaje")
public class CatResultadoAprendizaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "descripcion")
	private String descripcion;
	@ManyToOne
	@JoinColumn(name =  "id_programa")
	private Programa programa;
	@ManyToOne
	@JoinColumn(name =  "id_proceso")
	private Proceso proceso;

}
