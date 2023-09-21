package com.nicodoss.tpspring.mappers;

import com.nicodoss.tpspring.SpringApplicationContextProvider;
import com.nicodoss.tpspring.dtos.AdresseDto;
import com.nicodoss.tpspring.dtos.PersonnePhysiqueDto;
import com.nicodoss.tpspring.entites.Adresse;
import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.repositories.PaysRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


@Mapper(componentModel = "spring")
public interface PersonnePhysMappers {
    PersonnePhysMappers INSTANCE= Mappers.getMapper( PersonnePhysMappers.class );
    
    
    
    @Mapping(source = "paysNaissance.codePays", target = "codePaysNaissance")
    @Mapping(source = "paysResidence.codePays", target = "codePaysResidence")
    @Mapping(source="adresse",target="adresseDto",qualifiedByName = "AdresseListToAdresseDtoList")
    PersonnePhysiqueDto ModelToDto(PersonnePhysique prsPhys);
    
    @Named("codePaysToPaysNaissance")
    default Pays codePaysToPaysNaissance(String codePays)
    {
        System.out.println(codePays);
        ApplicationContext context= SpringApplicationContextProvider.getApplicationContext();;
        PaysRepository paysRepository=context.getBean(PaysRepository.class);
        return paysRepository.findById(codePays).orElseThrow(null);
    }
    //méthodes pour mapper une adresseList à une adresse Dtos
    @Named("AdresseListToAdresseDtoList")
    default List<AdresseDto> AdresseListToAdresseDtoList(List<Adresse>listeAdresse){
        System.out.print("conversion d'une AdresseListe vers une adresseDtos");
        return listeAdresse.stream().map(adresse->AdresseMappers.INSTANCE.ModelToDto(adresse)).collect(Collectors.toList());
}
    //méthodes pour mapper les addresseDtos pour Adresses 
    @Named("AdresseDtoListToAdresseList")
    default List<Adresse> AdresseDtoListToAdresseList(List<AdresseDto>listeAdresse){
        System.out.print("conversion d'une AdresseListeDtos vers une adresse");
        return listeAdresse.stream().map(adresse->AdresseMappers.INSTANCE.DtoToModel(adresse)).collect(Collectors.toList());
    } 
    @InheritInverseConfiguration
    @Mapping(source="prsPhysDTO.codePaysNaissance",target = "paysNaissance",qualifiedByName = "codePaysToPaysNaissance")
    @Mapping(source="prsPhysDTO.codePaysResidence",target = "paysResidence",qualifiedByName = "codePaysToPaysNaissance")
    @Mapping(source="adresseDto",target="adresse",qualifiedByName = "AdresseDtoListToAdresseList")
    PersonnePhysique dtoToModel(PersonnePhysiqueDto prsPhysDTO);
}
