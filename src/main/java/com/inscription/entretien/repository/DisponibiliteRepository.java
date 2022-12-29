package com.inscription.entretien.repository;

import com.inscription.entretien.entity.Disponibilite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisponibiliteRepository extends JpaRepository<Disponibilite, Long> {
    Page<Disponibilite> findByCompteId(Long compteId, Pageable pageable);

    Optional<Disponibilite> findByIdAndCompteId(Long Id,  Long compteId);
}

