package com.hdi.prueba.repository;

import com.hdi.prueba.model.Poliza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza, Integer> {
    Poliza findByAsegurado(String asegurado);
    Poliza findByIdPoliza(Integer idPoliza);
    List<Poliza> findByAseguradoContainingIgnoreCase(String asegurado);
    @Query("SELECT p FROM Poliza p WHERE " +
            "(:asegurado IS NULL OR :asegurado = '' OR LOWER(p.asegurado) LIKE LOWER(CONCAT('%', :asegurado, '%'))) " +
            "AND (:noPoliza IS NULL OR p.noPoliza = :noPoliza)")
    List<Poliza> findByAseguradoContainingIgnoreCaseOrNoPoliza(
            @Param("asegurado") String asegurado,
            @Param("noPoliza") Integer noPoliza);
}
