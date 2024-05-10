package com.nicodoss.tpspring.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.nicodoss.tpspring.entites.Pieces}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PiecesDto implements Serializable {
    Long refPiece;
    String LibellePiece;
    String linkpiece;
    PersonneDTO personne;
}