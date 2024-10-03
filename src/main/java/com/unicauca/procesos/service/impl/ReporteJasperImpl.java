package com.unicauca.procesos.service.impl;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.lowagie.text.DocumentException;
import com.unicauca.procesos.domain.Asignatura;
import com.unicauca.procesos.domain.Programa;
import com.unicauca.procesos.domain.catalogos.Factor;
import com.unicauca.procesos.dto.AspectoDTO;
import com.unicauca.procesos.dto.CalificacionReporte;
import com.unicauca.procesos.dto.CaracteristicaDTO;
import com.unicauca.procesos.dto.ResponsableAcreditacionReporte;
import com.unicauca.procesos.dto.TitulosFactoresYCaracteristicasDTO;
import com.unicauca.procesos.dto.comite.ComiteReporte;
import com.unicauca.procesos.dto.cronogramaActividad.CronogramaActividadesReporte;
import com.unicauca.procesos.dto.docente.DocenteReporte;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteDocumentalReporte;
import com.unicauca.procesos.dto.fuenteInformacion.FuenteNoDocumentalReporte;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import com.unicauca.procesos.dto.ponderacion.PonderacionFactorReporte;
import com.unicauca.procesos.dto.ponderacion.PonderadoCaracteristicaReporte;
import com.unicauca.procesos.mapper.CalificacionMapper;
import com.unicauca.procesos.mapper.ComiteMapper;
import com.unicauca.procesos.mapper.CronogramaActividadesMapper;
import com.unicauca.procesos.mapper.DocenteMapper;
import com.unicauca.procesos.mapper.FuenteInformacionMapper;
import com.unicauca.procesos.mapper.PonderacionMapper;
import com.unicauca.procesos.mapper.ResponsableAcreditacionMapper;
import com.unicauca.procesos.repository.AsignaturaRepository;
import com.unicauca.procesos.repository.CalificacionRepository;
import com.unicauca.procesos.repository.CatAspectoRepository;
import com.unicauca.procesos.repository.CatCaracteristicaRepository;
import com.unicauca.procesos.repository.CatFactorRepository;
import com.unicauca.procesos.repository.ComiteRepository;
import com.unicauca.procesos.repository.CronogramaActividadesRepository;
import com.unicauca.procesos.repository.DocenteRepository;
import com.unicauca.procesos.repository.FuenteInformacionRepository;
import com.unicauca.procesos.repository.PlanEstudioRepository;
import com.unicauca.procesos.repository.PonderacionRepository;
import com.unicauca.procesos.repository.ProgramaRepository;
import com.unicauca.procesos.repository.ResponsableAcreditacionRepository;
import com.unicauca.procesos.service.ReporteJasperService;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HttpServletBean;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReporteJasperImpl extends HttpServletBean implements ReporteJasperService {
	private AsignaturaRepository asignaturaRepository;
	private ProgramaRepository programaRepository;
	private DocenteRepository docenteRepository;
	private ComiteRepository comiteRepository;
	private ResponsableAcreditacionRepository responsableAcreditacionRepository;
	private CronogramaActividadesRepository actividadesRepository;
	private FuenteInformacionRepository fuenteInformacionRepository;
	private CalificacionRepository calificacionRepository;
	private PonderacionRepository ponderacionRepository;
	private CatCaracteristicaRepository catCaracteristicaRepository;
	private CatFactorRepository catFactorRepository;
	private CatAspectoRepository catAspectoRepository;
	private PlanEstudioRepository planEstudioRepository;
	@Override
	public ByteArrayOutputStream exportar(final Long idPrograma, final Long idProceso) throws IOException, JRException {
		String rutaAbsoluta = System.getProperty("user.dir") + "/pruebaJasper.jasper";
		File archivoJasper = new File(rutaAbsoluta);
		ByteArrayOutputStream resultado = new ByteArrayOutputStream();
		// Obtén la referencia al ClassLoader actual
		ClassLoader classLoader = ReporteJasperImpl.class.getClassLoader();
		InputStream ip = new FileInputStream(archivoJasper);
		Map<String, Object> params = new HashMap<>();
		List<Asignatura> asignaturas = this.asignaturaRepository.findByPlanEstudioId(planEstudioRepository.findByProcesoId(idProceso).getId());
		this.agregarInfoPrograma(params, idPrograma);
		this.agregarDocentes(params, idPrograma);
		this.agregarComite(params, idPrograma, idProceso);
		this.agregarResponsableAcreditacion(params, idPrograma, idProceso);
		this.agregarCronogramaActividades(params, idPrograma, idProceso);
		this.agregarFuentesDocumental(params, idProceso);
		this.agregarFuentesNoDocumental(params, idProceso);
		this.agregarCalificacion(params, idProceso);
		this.agregarPonderacionFactores(params, idProceso);
		this.agregarPonderacionCaracteristicas(params, idProceso);
		params.put("tituloFactoresYCaracteristicas", this.agregarTitulosFactoresYCaracteristicas(params, idProceso, false));
		params.put("resultadosEvaluacion", this.agregarTitulosFactoresYCaracteristicas(params, idProceso, true));
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(asignaturas.toArray());
		params.put("asignaturasDTO", ds);
		JasperPrint jasperPrint = JasperFillManager.fillReport(ip,params, ds);
		JasperExportManager.exportReportToPdfStream(jasperPrint, resultado);
		resultado.flush();
		resultado.close();
		return resultado;
	}
	private void agregarInfoPrograma(Map<String, Object> params, final Long idPrograma) {
		Optional<Programa> reseñaHistorica = programaRepository.findById(idPrograma);
		Programa programa = reseñaHistorica.get();
		if (programa.getResenaHistorica()!= null) {
			params.put("resenaHistorica", programa.getResenaHistorica());
		} else {
			params.put("resenaHistorica", "Sin información");
		}
		if (programa.getRecursosInfraestructura()!=null) {
			params.put("infraestructuraDelPrograma", programa.getRecursosInfraestructura());
		} else {
			params.put("infraestructuraDelPrograma", "Sin información");
		}
		if (programa.getRecursosAudiovisuales()!=null) {
			params.put("recursosInformaticos", programa.getRecursosAudiovisuales());
		} else {
			params.put("recursosInformaticos", "Sin información");
		}
		if (programa.getRecursosBibiliograficos()!=null) {
			params.put("recusosBibliografico", programa.getRecursosBibiliograficos());
		} else {
			params.put("recusosBibliografico", "Sin información");
		}
		if (programa.getRecursosBibliotecasUniversidad()!=null) {
			params.put("bibliotecasUniversidad", programa.getRecursosBibliotecasUniversidad());
		} else {
			params.put("bibliotecasUniversidad", "Sin información");
		}
		if (programa.getRecursosBibliotecasFacultad()!=null) {
			params.put("bibliotecasFacultad", programa.getRecursosBibliotecasFacultad());
		} else {
			params.put("bibliotecasFacultad", "Sin información");
		}
		if (programa.getMetodologia()!=null) {
			params.put("metodologia", programa.getMetodologia());
		} else {
			params.put("metodologia", "Sin información");
		}
		if (programa.getObjetivos()!=null) {
			params.put("objetivo", programa.getObjetivos());
		} else {
			params.put("objetivo", "Sin información");
		}
	}
	private void agregarDocentes(Map<String, Object> params, final Long idPrograma) {
		List<DocenteReporte> docentes = this.docenteRepository.findByProgramaId(idPrograma).stream().map(docente -> DocenteMapper.mapearEntidadADocenteReporte(docente)).collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(docentes.toArray());
		params.put("dsProfesores", ds);
	}

	private void agregarComite(Map<String, Object> params, final Long idPrograma, final Long idProceso) {
		List<ComiteReporte> comite = this.comiteRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso)
				.stream().map(comite1 -> ComiteMapper.mapEntidadComiteReporte(comite1)).collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(comite.toArray());
		params.put("dsComite", ds);
	}
	private void agregarResponsableAcreditacion(Map<String, Object> params, final Long idPrograma, final Long idProceso) {
		List<ResponsableAcreditacionReporte> responsables = this.responsableAcreditacionRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso)
				.stream().map(responsableAcreditacion -> ResponsableAcreditacionMapper.mapEntidadResponsableReporte(responsableAcreditacion))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(responsables.toArray());
		params.put("dsResponsables", ds);
	}
	private void agregarCronogramaActividades(Map<String, Object> params, final Long idPrograma, final Long idProceso) {
		List<CronogramaActividadesReporte> actividades = this.actividadesRepository.findByProgramaIdAndProcesoId(idPrograma, idProceso)
				.stream().map(actividad -> CronogramaActividadesMapper.mapearEntidadReporte(actividad))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(actividades.toArray());
		params.put("dsCronogramaActividades", ds);
	}
	private void agregarFuentesDocumental(Map<String, Object> params, final Long idProceso) {
		List<FuenteDocumentalReporte> documentalReportes = this.fuenteInformacionRepository.findByProcesoIdAndDocumental(idProceso, true)
				.stream().map(fuenteInformacion -> FuenteInformacionMapper.mapearFuenteDocumental(fuenteInformacion))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(documentalReportes.toArray());
		params.put("dsDocumentales", ds);
	}
	private void agregarFuentesNoDocumental(Map<String, Object> params, final Long idProceso) {
		List<FuenteNoDocumentalReporte> documentalReportes = this.fuenteInformacionRepository.findByProcesoIdAndDocumental(idProceso, false)
				.stream().map(fuenteInformacion -> FuenteInformacionMapper.mapearFuenteNoDocumental(fuenteInformacion))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(documentalReportes.toArray());
		params.put("dsNoDocumentales", ds);
	}
	private void agregarCalificacion(Map<String, Object> params, final Long idProceso) {
		List<CalificacionReporte> calificacion = this.calificacionRepository.findByProcesoId(idProceso)
				.stream().map(calificacion1 -> CalificacionMapper.mapearEntidadCalReporte(calificacion1))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(calificacion.toArray());
		params.put("dsEscalaCalificacion", ds);
	}

	private void agregarPonderacionFactores(Map<String, Object> params, final Long idProceso) {
		List<PonderacionFactorReporte> ponFactores = this.ponderacionRepository.findByProcesoIdAndFactorIsNotNullAndCaracteristicaIsNull(idProceso)
				.stream().map(ponderacion -> PonderacionMapper.mapPonderadoFactor(ponderacion))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(ponFactores.toArray());
		params.put("dsPonderacionFactores", ds);
	}
	private void agregarPonderacionCaracteristicas(Map<String, Object> params, final Long idProceso) {
		List<PonderadoCaracteristicaReporte> ponCaracteristicas = this.ponderacionRepository.findByProcesoIdAndCaracteristicaIsNotNullAndAspectoIsNull(idProceso)
				.stream().map(ponderacion -> PonderacionMapper.mapPonderadoCaracteristica(ponderacion))
				.collect(Collectors.toList());
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(ponCaracteristicas.toArray());
		params.put("dsPonderacionCaracteristicas", ds);
	}

	private JRBeanArrayDataSource agregarTitulosFactoresYCaracteristicas(Map<String, Object> params, final Long idProceso, final Boolean agregarAspectos) {
		List<TitulosFactoresYCaracteristicasDTO> resultado = this.crearListaFactoresYCaracteristicas(idProceso, agregarAspectos);
		JRBeanArrayDataSource ds = new JRBeanArrayDataSource(resultado.toArray(new TitulosFactoresYCaracteristicasDTO[0]));
		return ds;
	}
	private List<TitulosFactoresYCaracteristicasDTO> crearListaFactoresYCaracteristicas(final Long idProceso, final Boolean agregarAspectos) {
		List<Factor> factores = this.catFactorRepository.findAll();
		return factores.stream().map(factor -> llenarCaracteristicasDeLosFactores(factor, idProceso, agregarAspectos)).collect(Collectors.toList());
	}

	private TitulosFactoresYCaracteristicasDTO llenarCaracteristicasDeLosFactores(Factor factor, final Long idProceso, final Boolean agregarAspectos) {
		return TitulosFactoresYCaracteristicasDTO.builder()
				.factor(factor.getNombre())
				.apreciacionGlobalFactor(
						agregarAspectos ?
								new JRBeanArrayDataSource(this.construirApreciacionGlobalFactor(idProceso, factor.getId()).toArray(new PonderacionDTO[0]))
								: null
				)
				.idFactor(factor.getId())
				.listaCaracteristicas(
						new JRBeanArrayDataSource(this.construirCaracteristicaDTO(factor.getId(), idProceso, agregarAspectos).toArray(new CaracteristicaDTO[0]))
						)
				.build();
	}
	private List<CaracteristicaDTO> construirCaracteristicaDTO(Long idFactor, final Long idProceso, final Boolean agregarAspectos) {
		return this.catCaracteristicaRepository.findByFactorId(idFactor).stream().map(caracteristica -> CaracteristicaDTO.builder()
				.nombreCaracteristica(caracteristica.getNombre())
				.idCaracteristica(caracteristica.getId())
				.listaAspectos(
						agregarAspectos ? new JRBeanArrayDataSource(this.construirAspectoDTO(caracteristica.getId(), idProceso).toArray(new AspectoDTO[0])) : null
				)
				.build()).collect(Collectors.toList());
	}
	private List<AspectoDTO> construirAspectoDTO(final Long idCaracteristica, final Long idProceso) {
		return this.ponderacionRepository.findByProcesoIdAndCaracteristicaIdAndAspectoIsNotNull(idProceso, idCaracteristica).stream()
				.map(ponderacion -> AspectoDTO.builder()
						.aspecto(ponderacion.getAspecto().getDescripcion())
						.calificacion(ponderacion.getCalificacion())
						.ponderacion(ponderacion.getPonderado()).build())
				.collect(Collectors.toList());
	}
	private List<PonderacionDTO> construirApreciacionGlobalFactor(final Long idProceso, final Long idFactor) {
		return this.ponderacionRepository.findByProcesoIdAndCaracteristicaIsNotNullAndFactorId(idProceso, idFactor).stream().map(PonderacionMapper::mapearDTO).collect(Collectors.toList());
	}
}
