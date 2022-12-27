package com.inscription.entretien.service;

import com.inscription.entretien.entity.Disponibilite;
import com.inscription.entretien.repository.DisponibiliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibiliteService {
    @Autowired
    private DisponibiliteRepository repository;

    public Disponibilite saveDisponibilite(Disponibilite disponibilite){
       return repository.save(disponibilite);
    }

    public List<Disponibilite> savaDisponibilites(List<Disponibilite> disponibilites){
        return repository.saveAll(disponibilites);
    }

    public List<Disponibilite> getDisponibilites(){
        return repository.findAll();
    }

    public Disponibilite getDisponibiliteById(Long Id){
        return repository.findById(Id).orElse(null);
    }

    public String deleteDisponibilite(Long Id){
        repository.deleteById(Id);
        return "Disponibilite supprime" + Id;
    }

    public Disponibilite updateDisponibilite(Disponibilite disponibilite){
        Disponibilite existingDisponibilite  = repository.findById(disponibilite.getId()).orElse(null);
        existingDisponibilite.setDate_disponibilite(disponibilite.getDate_disponibilite());
        existingDisponibilite.setDebut_disponibilite(disponibilite.getDebut_disponibilite());
        existingDisponibilite.setFin_disponibilite(disponibilite.getFin_disponibilite());
        return repository.save(existingDisponibilite);
    }

}
