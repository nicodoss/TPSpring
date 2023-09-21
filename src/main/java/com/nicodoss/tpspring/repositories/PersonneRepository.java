package com.nicodoss.tpspring.repositories;

import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.enums.TypePersonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne,Long> {
List<Personne>findByTypePersonne(TypePersonne type);
@Query("select p from Personne p where p.id =:adresseId")
Personne getPersonneByAdresseId(@Param("adresseId") Long Id);
}
