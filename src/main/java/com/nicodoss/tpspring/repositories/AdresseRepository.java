package com.nicodoss.tpspring.repositories;

import com.nicodoss.tpspring.entites.Adresse;
import com.nicodoss.tpspring.entites.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdresseRepository extends JpaRepository<Adresse,Long> {
}
