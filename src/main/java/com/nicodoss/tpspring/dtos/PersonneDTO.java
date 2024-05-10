package com.nicodoss.tpspring.dtos;
import com.nicodoss.tpspring.enums.TypePersonne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public abstract class PersonneDTO{
    private Long id;
    private List<AdresseDto> adresse;
    private List<PiecesDto>pieces;
    private TypePersonne typePersonne;

}
