package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import java.io.Serializable;

@Data
@Builder
public class CaracteristicaDTO implements Serializable {
	private Long idCaracteristica;
	private String nombreCaracteristica;
	private JRBeanArrayDataSource listaAspectos;
}
