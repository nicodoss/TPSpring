package com.nicodoss.tpspring.mappers;

import com.nicodoss.tpspring.SpringApplicationContextProvider;
import com.nicodoss.tpspring.dtos.PersonneDTO;
import com.nicodoss.tpspring.dtos.PersonneMoraleDto;
import com.nicodoss.tpspring.dtos.PersonnePhysiqueDto;
import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.mapstruct.SubclassExhaustiveStrategy.RUNTIME_EXCEPTION;

@Mapper(componentModel = "spring",subclassExhaustiveStrategy = RUNTIME_EXCEPTION,
        uses = {AdresseMapper.class,PaysMappers.class,PiecesMapper.class})

public interface PersonneMapper {
    PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);
    @SubclassMapping( source = PersonnePhysiqueDto.class, target = PersonnePhysique.class )
    @SubclassMapping( source = PersonneMoraleDto.class, target = PersonneMorale.class )
    Personne toEntity( PersonneDTO source );

    @SubclassMapping( source = PersonnePhysique.class, target = PersonnePhysiqueDto.class )
    @SubclassMapping( source = PersonneMorale.class, target = PersonneMoraleDto.class )
    PersonneDTO toDto ( Personne source );


    List<Personne> toEntity(List<PersonneDTO> source );
    List<PersonneDTO> toDto ( List<Personne> source );
}

