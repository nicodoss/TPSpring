package com.nicodoss.tpspring.entites;

import javax.persistence.Embeddable;
import java.util.List;


@Embeddable
public class Adresse {
private String boitePostale;
private String rueAdresse;
private String tel;
private String email;
private String ville;
private String itineraire;
}
