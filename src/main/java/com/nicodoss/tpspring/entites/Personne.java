package com.nicodoss.tpspring.entites;

import com.nicodoss.tpspring.enums.TypePersonne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Type_Pers",length = 8)
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    protected Date dateCreationServeur;
    @Enumerated(value = EnumType.STRING)
    protected TypePersonne typePersonne;
    @Version
    private int rowversions;
    @OneToMany(mappedBy ="personne" )
    private List<Adresse> adresse;
}
