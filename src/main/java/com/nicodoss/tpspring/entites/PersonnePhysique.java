package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.persistence.*;
import java.util.List;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Table(name="T_PersonnePhysique")
@Entity @NoArgsConstructor @AllArgsConstructor @Data
@DiscriminatorValue("PH")
public class PersonnePhysique extends Personne{
    private String nom;
    private String prenoms;
    @OneToOne
    @Column(name = "paysNaissance")
    private Pays paysNaissance;
    @OneToOne
    @Column(name = "paysResidence")
    private Pays paysResidence;
    @Column(name = "lieuNaissance")
    private String lieuNaissance;
    @Embedded(onEmpty =  USE_NULL)
    private Adresse adresse;
    @Column(name = "estActifPersonne")
    private boolean estActifPersonne;

}
