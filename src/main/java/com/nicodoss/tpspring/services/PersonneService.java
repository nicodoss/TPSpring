package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.entites.Personne;

import java.util.List;

public interface PersonneService {

  Personne SavePersonne(Personne personne);
  void DeletePersonne(Long Id);
  Personne UpdatePersonne(Personne personne);
  List<Personne>ListePersonne();
  Personne FindById(Long Id);
}
