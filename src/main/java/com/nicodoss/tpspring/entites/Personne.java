package com.nicodoss.tpspring.entites;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,length = 2, name="Type_Personne")
public abstract class Personne {
    @Id
    Long id ;
    Date dateCreationServeur;
    int numLigne;

}
