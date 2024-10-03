package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.ReporteDTO;
import com.unicauca.procesos.service.ReporteJasperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@AllArgsConstructor
@Tag(name = "Reporte Controller" , description = "Servicios para generar el documento")
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {
	@Autowired
	private ReporteJasperService reporteJasperService;
	@Autowired
	private DataSource dataSource;

	@Operation(summary = "Generar reporte")
    @PostMapping("/generar/{idPrograma}/{idProceso}")
    public ResponseEntity<ReporteDTO> generarReporte(@PathVariable Long idPrograma, @PathVariable Long idProceso) throws JRException, IOException {
		byte[] archivoBytes = reporteJasperService.exportar(idPrograma, idProceso).toByteArray();
		return ResponseEntity.ok().body(ReporteDTO.builder()
				.application("application/pdf")
				.base64(Base64.getEncoder().encodeToString(archivoBytes))
				.build());
    }
}
