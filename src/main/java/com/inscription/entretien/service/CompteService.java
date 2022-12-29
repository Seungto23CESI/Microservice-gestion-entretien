package com.inscription.entretien.service;

import com.inscription.entretien.entity.Compte;
import com.inscription.entretien.exception.ResourceNotFoundException;
import com.inscription.entretien.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;


    public Page<Compte> getAllComptes(Pageable pageable) {
        return compteRepository.findAll(pageable);
    }

    public Compte createCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{compteId}")
    public Compte updateCompte(@PathVariable Long compteId, @RequestBody Compte compteRequest) {
        return compteRepository.findById(compteId).map(compte -> {
            compte.setNom(compteRequest.getNom());
            compte.setEmail(compteRequest.getEmail());
            return compteRepository.save(compte);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + compteId + " not found"));
    }


    @DeleteMapping("/comptes/{compteId}")
    public ResponseEntity<?> deletCompte(@PathVariable Long compteId) {
        return compteRepository.findById(compteId).map(compte -> {
            compteRepository.delete(compte);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + compteId + " not found"));
    }


}
