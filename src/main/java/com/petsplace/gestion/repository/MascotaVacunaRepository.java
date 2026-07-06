package com.petsplace.gestion.repository;

import com.petsplace.gestion.model.MascotaVacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotaVacunaRepository extends JpaRepository<MascotaVacuna, Long> {
    List<MascotaVacuna> findByMascotaId(Long mascotaId);
}
