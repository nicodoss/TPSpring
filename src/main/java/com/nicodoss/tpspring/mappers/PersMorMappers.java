package com.nicodoss.tpspring.mappers;

import com.nicodoss.tpspring.SpringApplicationContextProvider;
import com.nicodoss.tpspring.dtos.PersonneMoraleDto;
import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.repositories.PaysRepository;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.context.ApplicationContext;

@Mapper(componentModel = "spring")
public interface PersMorMappers {
    PersMorMappers INSTANCE= Mappers.getMapper(PersMorMappers.class);
    @Named("PaysById")
    default void PaysById(String codePays){
        ApplicationContext context= SpringApplicationContextProvider.getApplicationContext();
        PaysRepository paysRepository=context.getBean(PaysRepository.class);
        Pays pays =paysRepository.findById(codePays).orElse(null);
    }
    @Mapping(source="pers.pays.codePays",target ="codepays")
    PersonneMoraleDto ModelToDtos(PersonneMorale pers);
    @InheritInverseConfiguration
    @Mapping(source = "pers.codepays",target="pays")
    PersonneMorale DtoToModel(PersonneMoraleDto pers);
}
