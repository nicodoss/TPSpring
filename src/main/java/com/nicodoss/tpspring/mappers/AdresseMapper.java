package com.nicodoss.tpspring.mappers;
import com.nicodoss.tpspring.dtos.AdresseDto;
import com.nicodoss.tpspring.entites.Adresse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING, uses = {PersonneMapper.class})
public interface AdresseMapper extends EntityMapper<AdresseDto, Adresse> {
    @Override
    ///@Mapping(target = "personne.id", source = "idPersonne")
    Adresse toEntity(AdresseDto adresseDto);
    @Override
    List<Adresse> toEntity(List<AdresseDto> adresseDto);
    @Override
    AdresseDto toDto(Adresse adresse);
    @Override
    List<AdresseDto> toDto(List<Adresse> entity);
}