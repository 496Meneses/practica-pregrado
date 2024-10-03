package com.unicauca.procesos.controller;

import com.unicauca.procesos.dto.proceso.ProcesoDTO;
import com.unicauca.procesos.service.ProcesoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Tag(name = "Proceso Controller" , description = "Serviciones relacionados con el proceso")
@RestController
@RequestMapping("/api/proceso")
public class ProcesoController {

    @Autowired
    private ProcesoService procesoService;
    @Operation(summary = "Iniciar proceso")
    @PostMapping("/iniciarProceso")
    public ProcesoDTO iniciarProceso(@RequestBody ProcesoDTO proceso) {
        return this.procesoService.inicarProceso(proceso);
    }
    @Operation(summary = "Consultar proceso por activo por el id del programa")
    @GetMapping("/existeProcesoActivo/{idPrograma}")
    public ProcesoDTO existeProcesoActivoParaPrograma(@PathVariable Long idPrograma) {
        return this.procesoService.consultarProcesoActivoPorIdPrograma(idPrograma);
    }
    @Operation(summary = "Consultar programa por id proceso")
    @GetMapping("/obtenerProcesoPorId/{idProceso}")
    public ProcesoDTO obtenerProcesoPorId(@PathVariable Long idProceso) {
        return this.procesoService.consultarProceso(idProceso);
    }
    @Operation(summary = "Obtener los procesos que a tenido el programa")
    @GetMapping("/listarProcesos/{idPrograma}")
    public List<ProcesoDTO> listarProcesosPorPrograma(@PathVariable Long idPrograma) {
        return this.procesoService.listarProcesosDelPrograma(idPrograma);
    }
    @Operation(summary = "Finalizar proceso")
    @GetMapping("/finalizarProceso/{idProceso}")
    public ProcesoDTO finalizarProceso(@PathVariable Long idProceso) {
        return this.procesoService.finalizarProceso(idProceso);
    }
    @PostMapping("/guardarJustificacionPrograma")
    public ProcesoDTO guardarJustificacionPrograma(@RequestBody ProcesoDTO proceso) {
        return this.procesoService.guardarJustificacionPrograma(proceso);
    }
}
