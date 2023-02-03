package com.nicodoss.tpspring.repositories;

import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.enums.TypePersonne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
List<Personne>findByTypePersonne(TypePersonne type);
}
