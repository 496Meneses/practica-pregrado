package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Calificacion;
import com.unicauca.procesos.domain.Ponderacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByProcesoId(final Long procesoId);
}
