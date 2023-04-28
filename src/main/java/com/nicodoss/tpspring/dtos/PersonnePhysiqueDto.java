package com.nicodoss.tpspring.dtos;

import com.nicodoss.tpspring.entites.Adresse;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Embedded;


import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;
@Data @AllArgsConstructor @NoArgsConstructor
public class PersonnePhysiqueDto extends Personne {
    private String nom;
    private String prenoms;
    private String codePaysNaissance;
    private String codePaysResidence;
    private String lieuNaissance;
    @Embedded(onEmpty =  USE_NULL)
    private Adresse adresse;
    private boolean estActifPersonne;
    private Sexe sexe;
    private Long numLigne;
    @Version
    private int rowversion;


}
