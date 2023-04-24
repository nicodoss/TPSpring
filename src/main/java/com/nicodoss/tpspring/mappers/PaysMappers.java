package com.nicodoss.tpspring.mappers;

import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.entites.Pays;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaysMappers {
    PaysMappers INSTANCE= Mappers.getMapper(PaysMappers.class);

    @BeforeMapping
    default void setDefaultValues(PaysDto paysDto, @MappingTarget Pays pays) {
        pays.setTailleTel(0);
        pays.setIndicatifReseau("000");
        pays.setLibelleGeographique("Néant");
    }

    PaysDto modelToDto(Pays pays);
    Pays dtoToModel(PaysDto paysdtos);
}
