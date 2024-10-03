package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.ResponsableAcreditacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Repository
@Service
public interface ResponsableAcreditacionRepository extends JpaRepository<ResponsableAcreditacion, Long> {
	List<ResponsableAcreditacion> findByProgramaId(Long idPrograma);

    List<ResponsableAcreditacion> findByProgramaIdAndProcesoId(Long idPrograma, Long idProceso);
}
