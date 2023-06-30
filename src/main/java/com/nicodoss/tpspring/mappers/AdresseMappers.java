package com.nicodoss.tpspring.mappers;

import com.nicodoss.tpspring.SpringApplicationContextProvider;
import com.nicodoss.tpspring.dtos.AdresseDto;
import com.nicodoss.tpspring.entites.Adresse;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.repositories.PersonneRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.ApplicationContext;


@Mapper(componentModel = "spring")
public interface AdresseMappers {
    AdresseDto ModelToDto(Adresse adresse);
    @Mapping(source = "adresseDto.idPersonne",target = "personne", qualifiedByName = "PersonneByAdresseId")
    Adresse DtoToModel(AdresseDto adresseDto);
    ApplicationContext context= SpringApplicationContextProvider.getApplicationContext();
    PersonneRepository pers=context.getBean (PersonneRepository.class);
    @Named("PersonneByAdresseId")
    default Personne personnebyadresse(Long idAdress)
    {
       return pers.getPersonneByAdresseId(idAdress);
    }
}
