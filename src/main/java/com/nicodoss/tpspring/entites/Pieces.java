package com.nicodoss.tpspring.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pieces implements Serializable {
@Id
private Long refPiece;
private String LibellePiece;
private String linkpiece;
@ManyToOne
@JoinColumn(name = "id_personne")
private Personne personne;

}
