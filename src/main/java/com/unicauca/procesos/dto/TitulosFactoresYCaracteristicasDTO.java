package com.unicauca.procesos.dto;
import lombok.Builder;
import lombok.Data;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class TitulosFactoresYCaracteristicasDTO implements Serializable {
	private Long idFactor;
	private String factor;
	private JRBeanArrayDataSource listaCaracteristicas;
	private JRBeanArrayDataSource apreciacionGlobalFactor;
}
