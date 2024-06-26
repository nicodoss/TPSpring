package com.nicodoss.tpspring.entites;

import com.nicodoss.tpspring.enums.Sexe;
import lombok.*;
import javax.persistence.*;
import java.util.List;
@Table(name="T_PersonnePhysique",schema = "OUVERTURE")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue("PH")
public class PersonnePhysique extends Personne {
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenoms;
    @OneToOne
    @JoinColumn(name = "id_pays_naissance")
    private Pays paysNaissance;
    @OneToOne
    @JoinColumn(name = "id_pays_residence")
    private Pays paysResidence;
    @Column(name = "lieu_naissance", length = 50)
    private String lieuNaissance;
    @OneToMany()
    private List<Adresse> adresse;
    @Column(name = "estactifPersonne")
    private boolean estActifPersonne;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numLigne")
    private Long numLigne;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    
}
