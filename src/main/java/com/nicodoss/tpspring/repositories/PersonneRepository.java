package com.nicodoss.tpspring.repositories;

import com.nicodoss.tpspring.entites.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Long> {

}
