package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.dtos.PersonneMoraleDto;
import com.nicodoss.tpspring.dtos.PersonnePhysiqueDto;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.repositories.PersonnePhysiqueRepository;
import com.nicodoss.tpspring.repositories.PersonneRepository;
import com.nicodoss.tpspring.services.PersonneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/personne")
public class PersonneController {

    private PersonneService personneService;

    @GetMapping(path = "/personnesphys")
    public List<Personne>ListePersonnePhysique( ){
       return   personneService.ListePersonne(TypePersonne.PHYSIQUE);
    }

    @PostMapping("/addPersPhys")
    public ResponseEntity<PersonnePhysiqueDto> Createpersonnephysique (@RequestBody PersonnePhysiqueDto personne){
        PersonnePhysiqueDto pers= personneService.SavePersonnePhysique(personne);
        return ResponseEntity.status(HttpStatus.CREATED).body(pers);
    }

    @PostMapping("/addPersMorale")
    public ResponseEntity<PersonneMoraleDto> CreatePersonneMorale (@RequestBody PersonneMoraleDto personne){
        PersonneMoraleDto pers=personneService.SavePersonneMorale(personne);
        return ResponseEntity.ok(pers);
    }

}
