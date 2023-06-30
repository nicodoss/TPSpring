package com.nicodoss.tpspring.dtos;

import com.nicodoss.tpspring.entites.Adresse;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
@Data @AllArgsConstructor @NoArgsConstructor
public class PersonnePhysiqueDto{
    private String nom;
    private String prenoms;
    private String codePaysNaissance;
    private String codePaysResidence;
    private String lieuNaissance;
    private boolean estActifPersonne;
    private Sexe sexe;
    private Long numLigne;
    private AdresseDto adresseDto;
    @Version
    private int rowversions;


}
