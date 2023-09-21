package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_CompteClient",schema = "OUVERTURE")
@AllArgsConstructor @NoArgsConstructor @Data
public class CompteClient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id ;
    @Column(length =20,name = "numCompte", nullable = false,updatable = false,unique = true)
    private String numCompte;
    private String intituleCompte;
    private String Abrege;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_CompteClientPersonne",schema = "OUVERTURE",
    joinColumns =@JoinColumn(name = "id_client"),inverseJoinColumns = @JoinColumn(name = "id_pers"))
    private Set<Personne> listePersonne;
    @OneToOne
    @JoinColumn(name = "id_pers_principal")
    private Personne personne ;
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="numLigne", nullable = false,updatable = false)
    private Long numLigne;
    @Version
    private int rowversions;
}
