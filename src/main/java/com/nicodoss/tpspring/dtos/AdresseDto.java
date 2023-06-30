package com.nicodoss.tpspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @NoArgsConstructor
public class AdresseDto {
    private int id;
    private String boitePostale;
    private String rueAdresse;
    private String tel;
    private String email;
    private String ville;
    private String itineraire;
    private Long idPersonne;
}
