package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Comite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Repository
@Service
public interface ComiteRepository extends JpaRepository<Comite, Long> {
	List<Comite> findByProgramaId(Long idPrograma);
    List<Comite> findByProgramaIdAndProcesoId(Long idPrograma, Long idProceso);
}
