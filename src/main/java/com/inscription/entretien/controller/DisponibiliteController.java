package com.inscription.entretien.controller;

import com.inscription.entretien.entity.Disponibilite;
import com.inscription.entretien.service.CompteService;
import com.inscription.entretien.service.DisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DisponibiliteController {
    @Autowired
    CompteService compteService;
    @Autowired
    DisponibiliteService disponibiliteService;

    @GetMapping("/comptes/{compteId}/disponibilites")
    public Page<Disponibilite> getAllDisponibilitesByCompteId(@PathVariable (value = "compteId") Long compteId,
                                                              Pageable pageable) {
        return disponibiliteService.getAllDisponibilitesByCompteId(compteId,pageable);
    }


    @PostMapping("/comptes/{compteId}/disponibilites")
    public Disponibilite createDisponibilite(@PathVariable (value = "compteId") Long compteId,
                                             @RequestBody Disponibilite disponibilite) {
        return disponibiliteService.createDisponibilite(compteId,disponibilite);
    }


    @PutMapping("/comptes/{compteId}/disponibilites/{disponibiliteId}")
    public Disponibilite updateDisponibilite(@PathVariable (value = "compteId") Long compteId,
                                             @PathVariable (value = "disponibiliteId") Long disponibiliteId,
                                             @RequestBody Disponibilite disponibiliteRequest) {
        return disponibiliteService.updateDisponibilite(compteId,disponibiliteId,disponibiliteRequest);
    }



    @DeleteMapping("/comptes/{compteId}/disponibilites/{disponibiliteId}")
    public ResponseEntity<?> deleteDisponibilite(@PathVariable (value = "compteId") Long compteId,
                                                 @PathVariable (value = "disponibiliteId") Long disponibiliteId) {
        return disponibiliteService.deleteDisponibilite(compteId, disponibiliteId);
    }
}