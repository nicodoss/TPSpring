package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.entites.Personne;
import com.nicodoss.tpspring.repositories.PersonneRepository;
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
    public Personne SavePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public void DeletePersonne(Long Id) {
        personneRepository.deleteById(Id);
    }


    @Override
    public Personne UpdatePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public List<Personne> ListePersonne() {
        return personneRepository.findAll();
    }

    @Override
    public Personne FindById(Long Id) {
        return personneRepository.findById(Id).orElse(null);
    }
}
