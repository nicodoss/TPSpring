package com.nicodoss.tpspring.entites;

import com.nicodoss.tpspring.enums.ZonePays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
@Table(name="T_Pays",schema = "OUVERTURE")
public class Pays{
    @Id
    @Column(name="codePays",length = 20)
    private String codePays;
    @Column(length = 50)
    private String nomPays;
    @Column(length = 5)
    private String  indicatifReseau;
    @Enumerated(EnumType.STRING)
    private ZonePays zonePays;
}
