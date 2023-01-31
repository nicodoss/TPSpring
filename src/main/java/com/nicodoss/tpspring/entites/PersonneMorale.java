package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor @AllArgsConstructor @Data
@DiscriminatorValue("PM")
@Table(name="T_PersonneMorale")
public class PersonneMorale extends Personne{
    private String numeroAgrement;
    private String numeroInsae;
    private String capitalSocial;
    private String siglePersonneMorale;
    private String libelleFormeJuridique;
    private String raisonSociale;
    private boolean estActifPersonne;
    private String codeLangue;
    @Temporal(TemporalType.DATE)
    private Date dateCreationServeur;
    @OneToOne
    private Pays pays;
}
