package com.unicauca.procesos.repository;

import com.unicauca.procesos.domain.Docente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Page<Docente> findByProgramaId(Long idPrograma, PageRequest pageRequest);
    List<Docente> findByProgramaId(Long idPrograma);
}
