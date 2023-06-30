package com.nicodoss.tpspring.mappers;
import com.nicodoss.tpspring.SpringApplicationContextProvider;
import com.nicodoss.tpspring.dtos.CompteClientDto;
import com.nicodoss.tpspring.entites.CompteClient;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.exceptions.PersonneNotExistException;
import com.nicodoss.tpspring.repositories.PersonneMoraleRepository;
import com.nicodoss.tpspring.repositories.PersonnePhysiqueRepository;
import com.nicodoss.tpspring.repositories.PersonneRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.ApplicationContext;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CompteClientMappers {
 @Mapping(source = "clt.personne.id", target = "idPersPrincip")
 @Mapping(source ="clt.listePersonne",target="listePersonne",qualifiedByName = "mapPersonneSetToIdSet")
 CompteClientDto ModelToDto(CompteClient clt);
 ApplicationContext context= SpringApplicationContextProvider.getApplicationContext();
 PersonneRepository pers=context.getBean(PersonneRepository.class);
 Set<Personne>listePersonne=new HashSet<>();
 @Named("listepersonneByID")
 default  Set <Personne>mapPersonneIDToPersonne(Set<Long> ids) throws PersonneNotExistException {
   for(Long p:ids)
   listePersonne.add(pers.findById(p).orElseThrow(()->new PersonneNotExistException(p)));
   return listePersonne;
 }
 //Mappage listeIDbyListePERS
 @Named("mapPersonneSetToIdSet")
 default Set<Long> mapPersonneSetToIdSet(Set<Personne> personnes) {
  Set<Long> ids = new HashSet<>();
  for (Personne personne : personnes) {
   ids.add(personne.getId());
  }
  return ids;
 }
 @Mapping(source ="clt.listePersonne",target="listePersonne",qualifiedByName = "listepersonneByID")
 CompteClient DtoToModel(CompteClientDto clt);
}
