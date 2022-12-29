package com.inscription.entretien.service;

import com.inscription.entretien.entity.Disponibilite;
import com.inscription.entretien.exception.ResourceNotFoundException;
import com.inscription.entretien.repository.CompteRepository;
import com.inscription.entretien.repository.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class DisponibiliteService {


    @Autowired
    private DisponibiliteRepository disponibiliteRepository;

    @Autowired
    private CompteRepository compteRepository;


    //GET ALL DISPONIBILITE BY ID
    public Page<Disponibilite> getAllDisponibilitesByCompteId(@PathVariable (value = "compteId")
                                                              Long compteId, Pageable pageable) {
        return disponibiliteRepository.findByCompteId(compteId, pageable);
    }


    //CREATE DISPONIBILITE
    public Disponibilite createDisponibilite(@PathVariable (value = "compteId") Long compteId,
                                             @RequestBody Disponibilite disponibilite) {
        return compteRepository.findById(compteId).map(compte -> {
            disponibilite.setCompte(compte);
            return disponibiliteRepository.save(disponibilite);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + compteId + " not found"));
    }


    // UPDATE DISPONIBILITE
    @PutMapping("/comptes/{compteId}/disponibilites/{disponibiliteId}")
    public Disponibilite updateDisponibilite(@PathVariable (value = "compteId") Long compteId,
                                             @PathVariable (value = "disponibiliteId") Long disponibiliteId,
                                             @RequestBody Disponibilite disponibiliteRequest) {
        if(!compteRepository.existsById(compteId)) {
            throw new ResourceNotFoundException("CompteId " + compteId + " not found");
        }

        return disponibiliteRepository.findById(disponibiliteId).map(disponibilite -> {
            disponibilite.setDebut_disponibilite(disponibiliteRequest.getDebut_disponibilite());
            disponibilite.setDate_disponibilite(disponibiliteRequest.getDate_disponibilite());
            disponibilite.setFin_disponibilite(disponibiliteRequest.getFin_disponibilite());
            return disponibiliteRepository.save(disponibilite);
        }).orElseThrow(() -> new ResourceNotFoundException("DisponibiliteId " + disponibiliteId + "not found"));
    }


    // DELETE DISPONIBILITE
    @DeleteMapping("/comptes/{compteId}/disponibilites/{disponibiliteId}")
    public ResponseEntity<?> deleteDisponibilite(@PathVariable (value = "compteId") Long compteId,
                                                 @PathVariable (value = "disponibiliteId") Long disponibiliteId) {
        return disponibiliteRepository.findByIdAndCompteId(disponibiliteId, compteId).map(disponibilite -> {
            disponibiliteRepository.delete(disponibilite);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Disponibilite not found with id " + disponibiliteId + " and compteId " + compteId));
    }
}
