package com.nicodoss.tpspring.dtos;

import com.nicodoss.tpspring.enums.Sexe;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
@Data @AllArgsConstructor @NoArgsConstructor
public class PersonnePhysiqueDto extends PersonneDTO{
    private String nom;
    private String prenoms;
    private String codePaysNaissance;
    private String codePaysResidence;
    private String lieuNaissance;
    private boolean estActifPersonne;
    private Sexe sexe;
    private Long numLigne;
    @Version
    private int rowversions;


}
