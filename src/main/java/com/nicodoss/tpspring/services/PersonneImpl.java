package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.entites.PersonneMorale;
import com.nicodoss.tpspring.entites.PersonnePhysique;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.repositories.PersonneRepository;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PersonneImpl implements PersonneService{
    private PersonneRepository personneRepository;


    @Override
    public Personne SavePersonnePhysique(PersonnePhysique personne) {

        return personneRepository.save(personne);
    }

    @Override
    public Personne SavePersonneMorale(PersonneMorale personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Personne SavePersonne(Personne personne) {

        TypePersonne typepersonne=personne.getTypePersonne();
        System.out.println(typepersonne);
        switch (typepersonne) {
            case PHYSIQUE:
                PersonnePhysique ph=(PersonnePhysique)personne;
                personneRepository.save(ph);
                break;
            case MORALE:
                PersonneMorale pm=(PersonneMorale)personne;
                personneRepository.save(pm);
        }
        return personne;
    }

    @Override
    public void DeletePersonne(Long Id) {
        personneRepository.deleteById(Id);
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
    public List<Personne> ListePersonne(TypePersonne typePersonne) {
        return personneRepository.findByTypePersonne(typePersonne);
    }
    @Override
    public List<Personne> ListePersonneAll() {
        return null;
    }

    @Override
    public Personne FindById(Long Id) {
        return personneRepository.findById(Id).orElse(null);
    }
}
