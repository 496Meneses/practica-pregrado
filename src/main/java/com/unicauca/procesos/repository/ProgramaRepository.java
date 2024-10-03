package com.unicauca.procesos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.unicauca.procesos.domain.Programa;

@Repository
@Service
public interface ProgramaRepository extends JpaRepository<Programa, Long> {

	@Query("SELECT COUNT(pr) FROM Programa pr")
	Integer numeroProgramas();
}
