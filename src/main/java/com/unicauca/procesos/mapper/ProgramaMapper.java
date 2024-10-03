package com.unicauca.procesos.mapper;

import com.unicauca.procesos.common.Constants;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.dto.programa.ListarProgramaResponse;
import com.unicauca.procesos.dto.programa.ProgramaRequest;
import com.unicauca.procesos.dto.programa.ProgramaResponse;
public class ProgramaMapper {
	private ProgramaMapper() { throw  new IllegalStateException(Constants.UTILITY_CLASS); }

	public static  Programa mapearEntidad(ProgramaRequest programaRequest) {
		return Programa.builder().nombre(programaRequest.getNombrePrograma())
				.alfa(programaRequest.getAlfa())
				.beta(programaRequest.getBeta())
				.gamma(programaRequest.getGamma())
				.delta(programaRequest.getDelta())
				.totalCreditos(programaRequest.getTotalCreditos())
				.fechaActualizacion(programaRequest.getFechaActualizacion())
				.estNumeroAspirantes(programaRequest.getNroAspirantes())
				.estNumeroEgresados(programaRequest.getNroEgresados())
				.estNumeroEstudiantes(programaRequest.getNroEstudiantesNuevosSemestre())
				.profNumeroPlanta(programaRequest.getNroProfesoresPlanta())
				.profNumeroCatedra(programaRequest.getNroProfesoresCatedra())
				.profNumeroOcasionalesTc(programaRequest.getNroProfesoresOcasionalesTiempoCompleto())
				.profNroOcacionalesMt(programaRequest.getNroProfesoresOcasionalesMedioTiempo())
				.numeroCredtiosSinCsr(programaRequest.getCreditosAcademicosSinRequisitoCRS())
				.numeroCreditosElectivosCe(programaRequest.getCreditosElectivosCE())
				.numeroCreditosSuceptibles(programaRequest.getCreditosSuceptiblesHomologacionPorResolucion())
				.numeroModalidadesMg(programaRequest.getModalidaesDeTrabajoDeGradoMG())
				.resenaHistorica(programaRequest.getResenaHistorica())
				.recursosInfraestructura(programaRequest.getInfraestructuraPrograma())
				.recursosAudiovisuales(programaRequest.getInformaticosYAudiovisuales())
				.recursosBibiliograficos(programaRequest.getRecursosBibliograficos())
				.recursosBibliotecasFacultad(programaRequest.getBibliotecasFacultad())
				.recursosBibliotecasUniversidad(programaRequest.getBibliotecasUniversidad())
				.idNivelFormacion(programaRequest.getIdNivelDeFormacion())
				.id(programaRequest.getIdPrograma())
				.metodologia(programaRequest.getMetodologia())
				.objetivos(programaRequest.getObjetivos())
				.nroTotalDeEstudiantes(programaRequest.getNroTotalDeEstudiantes())
				.totalCreditos(programaRequest.getTotalCreditos())
				.build();
	}
	public static ProgramaResponse mapearRespuesta(Programa programa) {
		return ProgramaResponse.builder().nombrePrograma(programa.getNombre())
				.nombre(programa.getNombre())
				.totalCreditos(programa.getTotalCreditos())
				.fechaActualizacion(programa.getFechaActualizacion())
				.nroEgresados(programa.getEstNumeroEgresados())
				.nroTotalDeEstudiantes(programa.getNroTotalDeEstudiantes())
				.nroProfesoresCatedra(programa.getProfNumeroCatedra())
				.nroEstudiantesNuevosSemestre(programa.getEstNumeroAspirantes())
				.nroAspirantes(programa.getEstNumeroEstudiantes())
				.nroProfesoresPlanta(programa.getProfNumeroPlanta())
				.nroProfesoresOcasionalesTiempoCompleto(programa.getProfNumeroOcasionalesTc())
				.nroProfesoresOcasionalesMedioTiempo(programa.getProfNroOcacionalesMt())
				.creditosAcademicosSinRequisitoCRS(programa.getNumeroCredtiosSinCsr())
				.creditosElectivosCE(programa.getNumeroCreditosElectivosCe())
				.creditosSuceptiblesHomologacionPorResolucion(programa.getNumeroCreditosSuceptibles())
				.modalidaesDeTrabajoDeGradoMG(programa.getNumeroModalidadesMg())
				.resenaHistorica(programa.getResenaHistorica())
				.infraestructuraPrograma(programa.getRecursosInfraestructura())
				.informaticosYAudiovisuales(programa.getRecursosAudiovisuales())
				.recursosBibliograficos(programa.getRecursosBibiliograficos())
				.bibliotecasFacultad(programa.getRecursosBibliotecasFacultad())
				.bibliotecasUniversidad(programa.getRecursosBibliotecasUniversidad())
				.idNivelDeFormacion(programa.getIdNivelFormacion())
				.idPrograma(programa.getId())
				.metodologia(programa.getMetodologia())
				.objetivos(programa.getObjetivos())
				.id(programa.getId())
				.alfa(programa.getAlfa())
				.beta(programa.getBeta())
				.gamma(programa.getGamma())
				.delta(programa.getDelta())
				.build();
	}

	public static ListarProgramaResponse mapearRespuestaLista(Programa programa) {
		return ListarProgramaResponse.builder().idNivelFormacion(programa.getIdNivelFormacion())
				.id(programa.getId())
				.nroTotalDeEstudiantes(programa.getNroTotalDeEstudiantes())
				.fechaActualizacion(programa.getFechaActualizacion())
				.resenaHistorica(programa.getResenaHistorica())
				.nombre(programa.getNombre()).build();
	}
}
