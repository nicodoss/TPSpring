package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
@Table(name="T_Pays",schema = "OUVERTURE")
public class Pays{
    @Id
    @Column(name="codePays",length = 20)
    private String codePays;
    private String libelleGeographique;
    private int tailleTel;
    private String  indicatifReseau;
}
