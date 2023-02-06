package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.repositories.PaysRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaysServiceImpl implements PaysService{
    @Autowired
    PaysRepository paysRepository ;
    @Override
    public Pays CreatePays(Pays pays) {
        return paysRepository.save(pays);

    }

    @Override
    public Pays UpdatePays(String codePays, Pays pays) {
        return null;
    }
}
