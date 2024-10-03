package com.unicauca.procesos.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ReporteDTO implements Serializable {
	private String application;
	private String base64;
}
