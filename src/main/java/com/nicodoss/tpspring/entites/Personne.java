package com.nicodoss.tpspring.entites;

import com.nicodoss.tpspring.enums.TypePersonne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,length = 2, name="Type_Personne")
@NoArgsConstructor @AllArgsConstructor @Data
public abstract class Personne {
    @Id
    protected Long id ;
    protected Date dateCreationServeur;
    @Enumerated(value = EnumType.STRING)
    protected TypePersonne typePersonne;
    int numLigne;

}
