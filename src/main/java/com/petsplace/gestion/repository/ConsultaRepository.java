package com.petsplace.gestion.repository;

import com.petsplace.gestion.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMascotaIdOrderByFechaDesc(Long mascotaId);
}
