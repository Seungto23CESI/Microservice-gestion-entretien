package com.inscription.entretien.controller;

import com.inscription.entretien.exception.ResourceNotFoundException;
import com.inscription.entretien.entity.Compte;
import com.inscription.entretien.repository.CompteRepository;
import com.inscription.entretien.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompteController {

    @Autowired
    CompteService compteService;

    //GET ALL COMPTE
    @GetMapping("/comptes")
    public Page<Compte> getAllComptes(Pageable pageable) {
        return compteService.getAllComptes(pageable);
    }

    //CREATE NEW COMPTE
    @PostMapping("/comptes")
    public Compte createCompte(@RequestBody Compte compte) {
        return compteService.createCompte(compte);
    }

    //UPDATE COMPTE
    @PutMapping("/comptes/{compteId}")
    public Compte updateCompte(@PathVariable Long compteId, @RequestBody Compte compteRequest){
        return compteService.updateCompte(compteId, compteRequest);
    }

    //DELETE COMPTE
    @DeleteMapping("/comptes/{compteId}")
    public ResponseEntity<?> deletCompte(@PathVariable Long compteId) {
        return compteService.deletCompte(compteId);
    }
}