package com.nicodoss.tpspring.entites;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_CompteClient",schema = "OUVERTURE")
public class CompteClient extends Personne{
    String intituleCompte;
    String Abrege;
    @ManyToMany
    @JoinTable(name = "T_Client_Personne",schema = "OUVERTURE",
    joinColumns =@JoinColumn(name = "id_client"),inverseJoinColumns = @JoinColumn(name = "id_pers"))
    private Set<Personne> listePersonne;
    @OneToOne
    @JoinColumn(name = "id_pers_principal")
    Personne personne ;
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="numLigne")
    private Long numLigne;
}
