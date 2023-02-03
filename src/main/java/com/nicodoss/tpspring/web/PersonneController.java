package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.repositories.PersonneRepository;
import com.nicodoss.tpspring.services.PersonneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor

public class PersonneController {

    private PersonneService personneService;

    @GetMapping(path = "/person_PH")
    public List<Personne>ListePersonnePhysique( ){
        return   personneService.ListePersonne(TypePersonne.PHYSIQUE);
    }

    @PostMapping("/CreatePers")
    public Personne personne (@RequestBody Personne personne){
        return personneService.SavePersonne(personne);

    }
//    @PostMapping()
//    public Personne personne (@RequestBody PersonneMorale personne){
//        return personneService.SavePersonneMorale(personne);
//    }
}
