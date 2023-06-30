package com.nicodoss.tpspring.mappers;

import com.nicodoss.tpspring.SpringApplicationContextProvider;
import com.nicodoss.tpspring.dtos.PersonnePhysiqueDto;
import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.repositories.PaysRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.ApplicationContext;

@Mapper(componentModel = "spring")
public interface PersonnePhysMappers {
    PersonnePhysMappers INSTANCE= Mappers.getMapper( PersonnePhysMappers.class );

    @Mapping(source = "paysNaissance.codePays", target = "codePaysNaissance")
    @Mapping(source = "paysResidence.codePays", target = "codePaysResidence")
    PersonnePhysiqueDto ModelToDto(PersonnePhysique prsPhys);
    @Named("codePaysToPaysNaissance")
    default Pays codePaysToPaysNaissance(String codePays)
    {
        System.out.println(codePays);
        ApplicationContext context= SpringApplicationContextProvider.getApplicationContext();;
        PaysRepository paysRepository=context.getBean(PaysRepository.class);
        return paysRepository.findById(codePays).orElseThrow(null);
    }

    @InheritInverseConfiguration
    @Mapping(source="prsPhysDTO.codePaysNaissance",target = "paysNaissance",qualifiedByName = "codePaysToPaysNaissance")
    @Mapping(source="prsPhysDTO.codePaysResidence",target = "paysResidence",qualifiedByName = "codePaysToPaysNaissance")
    PersonnePhysique dtoToModel(PersonnePhysiqueDto prsPhysDTO);
}
