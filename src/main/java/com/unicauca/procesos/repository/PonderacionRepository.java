package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.FuenteInformacion;
import com.unicauca.procesos.domain.Ponderacion;
import com.unicauca.procesos.dto.ponderacion.PonderacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Repository
@Service
public interface PonderacionRepository extends JpaRepository<Ponderacion, Long> {
    List<Ponderacion> findByProcesoIdAndCaracteristicaIsNotNullAndFactorId(final Long procesoId, final Long factorId);
    List<Ponderacion> findByProcesoIdAndFactorIsNotNull(final Long procesoId);
    List<Ponderacion> findByProcesoIdAndCaracteristicaIdAndAspectoIsNotNull(Long idProceso, Long idCaracteristica);

    Ponderacion findByProcesoIdAndCaracteristicaIdAndAspectoIsNull(Long idProceso, Long idCaracteristica);

    Ponderacion findByProcesoIdAndFactorIdAndCaracteristicaIsNull(Long idProceso, Long idFactor);

    // Obtener la ponderación de todos los factores
    List<Ponderacion> findByProcesoIdAndFactorIsNotNullAndCaracteristicaIsNull(Long idProceso);

    // Listar todas las ponderaciones de caracteristicas sin filtrar por factor
    List<Ponderacion> findByProcesoIdAndCaracteristicaIsNotNullAndAspectoIsNull(final Long procesoId);
}
