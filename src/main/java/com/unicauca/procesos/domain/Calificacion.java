package com.unicauca.procesos.domain;

import com.unicauca.procesos.domain.catalogos.Caracteristica;
import com.unicauca.procesos.domain.catalogos.Factor;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_calificacion")
public class Calificacion implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "grado_cumplimiento")
	private String gradoCumplimiento;
	@Column(name = "cal_letra")
	private String calLetra;
	@Column(name = "cal_numerica_desde")
	private BigDecimal calNumericaDesde;
	@Column(name = "cal_numerica_hasta")
	private BigDecimal calNumericaHasta;
	@Column(name = "val_porcentaje_desde")
	private BigDecimal valPorcentajeDesde;
	@Column(name = "val_porcentaje_hasta")
	private BigDecimal valPorcentajeHasta;
	@ManyToOne
	@JoinColumn(name = "id_proceso")
	private Proceso proceso;
}
