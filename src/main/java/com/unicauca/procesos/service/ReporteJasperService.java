package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.CalificacionDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface ReporteJasperService {
	ByteArrayOutputStream exportar(final Long idPrograma, final Long idProceso) throws IOException, JRException;
}
