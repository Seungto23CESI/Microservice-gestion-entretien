package com.inscription.entretien.controller;

import com.inscription.entretien.entity.Disponibilite;
import com.inscription.entretien.service.DisponibiliteService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisponibiliteController {
    @Autowired
    DisponibiliteService Service;

    @PostMapping("/addDisponibilite")
    public Disponibilite addDisponibilite(@RequestBody Disponibilite disponibilite){
        return Service.saveDisponibilite(disponibilite);
    }

    @PostMapping("/addDisponibilites")
    public List<Disponibilite> addDisponibilites(@RequestBody List<Disponibilite> disponibilites){
        return Service.savaDisponibilites(disponibilites);
    }

    @GetMapping("/Disponibilites")
    public List<Disponibilite> findAllDisponibilite(){
        return Service.getDisponibilites();
    }

    @GetMapping("/Disponibilite/{id}")
    public Disponibilite findDisponibiliteById(@PathVariable Long id){
        return Service.getDisponibiliteById(id);
    }

    @PutMapping("/update")
    public Disponibilite updateDisponibilite(@RequestBody Disponibilite disponibilite){
        return Service.updateDisponibilite(disponibilite);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDisponibilite(@PathVariable Long id){
        return Service.deleteDisponibilite(id);
    }


}
