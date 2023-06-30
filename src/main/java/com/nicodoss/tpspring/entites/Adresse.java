package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name="T_Adresse",schema = "OUVERTURE")
@Data @AllArgsConstructor @NoArgsConstructor
public class Adresse {
@Id
private Long id;
private String boitePostale;
private String rueAdresse;
private String tel;
private String email;
private String ville;
private String itineraire;
@ManyToOne
private Personne personne;
}
