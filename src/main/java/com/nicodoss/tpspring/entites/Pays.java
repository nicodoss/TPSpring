package com.nicodoss.tpspring.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Pays")
public class Pays {
    @Id @Column(name="codePays",length = 20)
    private String codePays;
    private String libelleGeographique;
    private int tailleTel;
    private String  indicatifReseau;
}
