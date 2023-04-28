package com.nicodoss.tpspring.dtos;
import com.nicodoss.tpspring.entites.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class PersonneMoraleDto extends Personne {
    private String numeroAgrement;
    private String numeroInsae;
    private long capitalSocial;
    private String siglePersonneMorale;
    private String libelleFormeJuridique;
    private String raisonSociale;
    private boolean estActifPersonne;
    private String codeLangue;
    private Date dateCreationServeur;
    private String codepays;
    private long numLigne;
    @Version
    private int rowversion;

}
