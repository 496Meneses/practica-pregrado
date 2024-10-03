package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.CronogramaActividad;
import com.unicauca.procesos.domain.FuenteInformacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface FuenteInformacionRepository extends JpaRepository<FuenteInformacion, Long> {
    List<FuenteInformacion> findByProcesoId(Long procesoId);
    List<FuenteInformacion> findByProcesoIdAndDocumental(final Long procesoId, final Boolean documental);
}
