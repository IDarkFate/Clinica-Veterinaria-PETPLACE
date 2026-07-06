package com.petsplace.gestion.repository;

import com.petsplace.gestion.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Long> {
    Optional<Boleta> findByNroBoleta(String nroBoleta);
    List<Boleta> findAllByOrderByFechaDesc();
}
