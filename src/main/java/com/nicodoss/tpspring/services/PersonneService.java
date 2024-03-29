package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.PersonneMoraleDto;
import com.nicodoss.tpspring.dtos.PersonnePhysiqueDto;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.enums.TypePersonne;

import java.util.List;

public interface PersonneService {

  PersonnePhysiqueDto SavePersonnePhysique(PersonnePhysiqueDto personne);
  PersonneMoraleDto SavePersonneMorale(PersonneMoraleDto personne);
  void DeletePersonne(Long Id);
  void DeletePersonnePhysique(Long Id);
  void DeletePersonneMorale(Long ID);
  Personne UpdatePersonne(Long ID,Personne personne);
  PersonnePhysique UpdatePersonnePhysique(Long ID,PersonnePhysique personne);
  PersonneMorale UpdatePersonneMorale(Long ID,PersonneMorale personne);
  List<Personne>ListePersonne(TypePersonne typePersonne);
  List<Personne>ListePersonneAll();
  Personne FindById(Long Id);
  List<PersonnePhysiqueDto>ListePersonnePhysique();
}
