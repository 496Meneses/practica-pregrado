package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {
	List<Archivo> findByFuenteInformacionId(Long fuenteInformacionId);
}
