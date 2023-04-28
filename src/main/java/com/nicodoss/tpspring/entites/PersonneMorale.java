package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data
@Table(name="T_PersonneMorale",schema = "OUVERTURE")
@DiscriminatorValue("PM")
public class PersonneMorale extends Personne{
    @Column(length = 100)
    private String numeroAgrement;
    @Column(length = 100)
    private String numeroInsae;
    private long capitalSocial;
    @Column(length = 100)
    private String siglePersonneMorale;
    @Column(length = 100)
    private String libelleFormeJuridique;
    @Column(length = 100)
    private String raisonSociale;
    private boolean estActifPersonne;
    @Column(length = 10)
    private String codeLangue;
    @Temporal(TemporalType.DATE)
    private Date dateCreationServeur;
    @OneToOne
    private Pays pays;
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="numLigne")
    private long numLigne;

}
