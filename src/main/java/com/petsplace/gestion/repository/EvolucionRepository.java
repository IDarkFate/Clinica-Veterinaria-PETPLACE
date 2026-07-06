package com.petsplace.gestion.repository;

import com.petsplace.gestion.model.Evolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvolucionRepository extends JpaRepository<Evolucion, Long> {
    List<Evolucion> findByMascotaIdOrderByFechaDesc(Long mascotaId);
}
