package com.nicodoss.tpspring.repositories;

import com.nicodoss.tpspring.entites.CompteClient;
import com.nicodoss.tpspring.enums.TypePersonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompteClientRepository extends JpaRepository<CompteClient, Long> {
@Query("select c From CompteClient c,Personne p where c.personne.typePersonne=p.typePersonne and p.typePersonne=:typePersonne")
List<CompteClient>FindCompteByTypePers(@Param("typePersonne") TypePersonne typePersonne);
CompteClient findByNumCompte(String numCompte);
}
