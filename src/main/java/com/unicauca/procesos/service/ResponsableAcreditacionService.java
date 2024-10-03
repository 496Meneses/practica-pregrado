package com.unicauca.procesos.service;

import com.unicauca.procesos.dto.ResponsableAcreditacionDTO;
import java.util.List;

public interface ResponsableAcreditacionService {
	ResponsableAcreditacionDTO crear (ResponsableAcreditacionDTO dto);
	List<ResponsableAcreditacionDTO> listarResponsableAcreditacionPorPrograma (Long idPrograma, Long idProceso);
	Boolean eliminarResponsable(Long idResponsable);
	ResponsableAcreditacionDTO consultarResponsablePorIdResponsable(Long idResponsable);
}