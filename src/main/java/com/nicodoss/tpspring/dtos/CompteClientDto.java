package com.nicodoss.tpspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;

import java.util.Set;
@Data @AllArgsConstructor @NoArgsConstructor
public class CompteClientDto {
    @JsonProperty(required = true,namespace = "numcompte")
    private String numCompte;
    private String intituleCompte;
    private String abrege;
    @JsonProperty(namespace = "signataires",required = true)
    private Set<Long> listePersonne;
    @JsonProperty(namespace = "persprinc")
    private  Long idPersPrincip ;
    private Long numLigne;
    @Version
    private int rowversion;


}
