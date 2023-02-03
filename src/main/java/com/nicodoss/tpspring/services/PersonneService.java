package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.enums.TypePersonne;

import java.util.List;

public interface PersonneService {

  Personne SavePersonnePhysique(PersonnePhysique personne);
  Personne SavePersonneMorale(PersonneMorale personne);
  Personne SavePersonne(Personne personne);
  void DeletePersonne(Long Id);
  Personne UpdatePersonne(Long ID,Personne personne);
  List<Personne>ListePersonne(TypePersonne typePersonne);
  List<Personne>ListePersonneAll();
  Personne FindById(Long Id);
}
