package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.List;


@Embeddable @Data @AllArgsConstructor @NoArgsConstructor
public class Adresse {
private String boitePostale;
private String rueAdresse;
private String tel;
private String email;
private String ville;
private String itineraire;
}
