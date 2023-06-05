package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.PersonneMoraleDto;
import com.nicodoss.tpspring.dtos.PersonnePhysiqueDto;
import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.mappers.PersMorMappers;
import com.nicodoss.tpspring.mappers.PersonnePhysMappers;
import com.nicodoss.tpspring.repositories.PersonneMoraleRepository;
import com.nicodoss.tpspring.repositories.PersonnePhysiqueRepository;
import com.nicodoss.tpspring.repositories.PersonneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.nicodoss.tpspring.enums.TypePersonne.PHYSIQUE;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PersonneServiceImpl implements PersonneService{
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private PersonnePhysiqueRepository personnePhysiqueRepository;
    @Autowired
    private PersonneMoraleRepository personneMoraleRepository;
    @Autowired
    private PersonnePhysMappers personnePhysMappers;
    @Autowired
    private PersMorMappers persMorMappers;
    @Override
    public PersonnePhysiqueDto SavePersonnePhysique(PersonnePhysiqueDto pers) {
    return personnePhysMappers.ModelToDto(personnePhysiqueRepository.save(personnePhysMappers.dtoToModel(pers)));
    }

    @Override
    public PersonneMoraleDto SavePersonneMorale(PersonneMoraleDto pers) {

        return persMorMappers.ModelToDtos(personneMoraleRepository.save(persMorMappers.DtoToModel(pers)));
    }


    @Override
    public void DeletePersonne(Long Id) {
        personneRepository.deleteById(Id);
    }

    @Override
    public void DeletePersonnePhysique(Long Id) {
        personnePhysiqueRepository.deleteById(Id);
    }

    @Override
    public void DeletePersonneMorale(Long ID) {
        personneMoraleRepository.deleteById(ID);
    }

    @Override
    public Personne UpdatePersonne(Long ID, Personne personne) {
        Personne pers =personneRepository.findById(ID).orElse(null);
        if(pers!=null){
            TypePersonne typepersonne=pers.getTypePersonne();
            switch(typepersonne) {
                case PHYSIQUE:

                    ((PersonnePhysique)pers).setNom(((PersonnePhysique)personne).getNom());
                    ((PersonnePhysique)pers).setAdresse(((PersonnePhysique)personne).getAdresse());
                    ((PersonnePhysique)pers).setEstActifPersonne(((PersonnePhysique)personne).isEstActifPersonne());
                    ((PersonnePhysique)pers).setLieuNaissance(((PersonnePhysique)personne).getLieuNaissance());
                    ((PersonnePhysique)pers).setPrenoms(((PersonnePhysique)personne).getPrenoms());
                    ((PersonnePhysique)pers).setPaysNaissance(((PersonnePhysique)personne).getPaysNaissance());
                    ((PersonnePhysique)pers).setDateCreationServeur(((PersonnePhysique)personne).getDateCreationServeur());
                    break;
                case MORALE:
                    ((PersonneMorale) pers).setSiglePersonneMorale(((PersonneMorale)personne).getSiglePersonneMorale());
                    ((PersonneMorale) pers).setCapitalSocial(((PersonneMorale)personne).getCapitalSocial());
                    ((PersonneMorale) pers).setLibelleFormeJuridique(((PersonneMorale)personne).getLibelleFormeJuridique());
                    ((PersonneMorale) pers).setNumeroAgrement(((PersonneMorale)personne).getNumeroAgrement());
                    ((PersonneMorale) pers).setPays(((PersonneMorale)personne).getPays());
                    ((PersonneMorale) pers).setEstActifPersonne(((PersonneMorale)personne).isEstActifPersonne());
                    ((PersonneMorale) pers).setRaisonSociale(((PersonneMorale)personne).getRaisonSociale());
                    ((PersonneMorale) pers).setCodeLangue(((PersonneMorale)personne).getCodeLangue());
                    break;
                default:
                    ((PersonneMorale) pers).setSiglePersonneMorale(((PersonneMorale)personne).getSiglePersonneMorale());
            }


        }
        return personneRepository.save(personne);
    }

    @Override
    public PersonnePhysique UpdatePersonnePhysique(Long ID, PersonnePhysique personne) {
        PersonnePhysique pers=personnePhysiqueRepository.findById(ID).orElse(null);
        if(pers!=null){
            pers.setNom(personne.getNom());
            pers.setAdresse(personne.getAdresse());
            pers.setEstActifPersonne(personne.isEstActifPersonne());
            pers.setLieuNaissance(personne.getLieuNaissance());
            pers.setPrenoms(personne.getPrenoms());
            pers.setPaysNaissance(personne.getPaysNaissance());
            pers.setDateCreationServeur(personne.getDateCreationServeur());
            pers.setPrenoms(personne.getPrenoms());
            pers.setPaysNaissance(personne.getPaysNaissance());
            pers.setPaysResidence(personne.getPaysResidence());
            pers.setTypePersonne(PHYSIQUE);
        }

        return pers;
    }

    @Override
    public PersonneMorale UpdatePersonneMorale(Long ID, PersonneMorale personne) {
        PersonneMorale pers =personneMoraleRepository.findById(ID).orElse(null);
        if(pers!=null) {
            pers.setSiglePersonneMorale(personne.getSiglePersonneMorale());
            pers.setCapitalSocial(personne.getCapitalSocial());
            pers.setLibelleFormeJuridique(personne.getLibelleFormeJuridique());
            pers.setNumeroAgrement(personne.getNumeroAgrement());
            pers.setPays(personne.getPays());
            pers.setEstActifPersonne(personne.isEstActifPersonne());
            pers.setRaisonSociale(personne.getRaisonSociale());
            pers.setCodeLangue(personne.getCodeLangue());
            pers.setDateCreationServeur(new Date());
            pers.setTypePersonne(TypePersonne.MORALE);
        }
        return pers;
    }

    @Override
    public List<Personne> ListePersonne(TypePersonne typePersonne) {
        switch (typePersonne) {
            case PHYSIQUE:
            return  personneRepository.findByTypePersonne(typePersonne).stream().map((element)->personnePhysMappers.ModelToDto((PersonnePhysique) element)).collect(Collectors.toList());
            default:
                return personneRepository.findByTypePersonne(typePersonne).stream().map((element)->persMorMappers.ModelToDtos((PersonneMorale) element)).collect(Collectors.toList());
        }
    }
    @Override
    public List<Personne> ListePersonneAll() {
        return personneRepository.findAll();
    }

    @Override
    public Personne FindById(Long Id) {
        return personneRepository.findById(Id).orElse(null);
    }

    @Override
    public List<PersonnePhysiqueDto> ListePersonnePhysique() {
        return personnePhysiqueRepository.findAll().stream().map(elt->personnePhysMappers.ModelToDto(elt)).collect(Collectors.toList());
    }
}
