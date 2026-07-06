package com.petsplace.gestion.repository;

import com.petsplace.gestion.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List<Documento> findByMascotaIdOrderByIdDesc(Long mascotaId);
}
