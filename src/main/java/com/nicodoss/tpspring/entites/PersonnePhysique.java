package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Embedded;

import javax.persistence.*;

import static org.springframework.data.relational.core.mapping.Embedded.OnEmpty.USE_NULL;

@Table(name="T_PersonnePhysique",schema = "OUVERTURE")
@Entity @NoArgsConstructor @AllArgsConstructor @Data @DiscriminatorValue("PH")
public class PersonnePhysique extends Personne{
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenoms;
    @OneToOne
    @JoinColumn(name="id_pays_naissance")
    private Pays paysNaissance;
    @OneToOne
    @JoinColumn(name="id_pays_residence")
    private Pays paysResidence;
    @Column(name = "lieu_naissance",length = 50)
    private String lieuNaissance;
    @Embedded(onEmpty =  USE_NULL)
    private Adresse adresse;
    @Column(name = "estactifPersonne")
    private boolean estActifPersonne;
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="numLigne")
    private Long numLigne;

}
