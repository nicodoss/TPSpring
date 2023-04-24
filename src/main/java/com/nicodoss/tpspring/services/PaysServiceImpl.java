package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.mappers.PaysMappers;
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
    @Autowired
    PaysMappers paysMappers;
    @Override
    public PaysDto CreatePays(PaysDto paysDto) {
        return paysMappers.modelToDto(paysRepository.save(paysMappers.dtoToModel(paysDto)));
    }
    @Override
    public PaysDto UpdatePays(String codePays, PaysDto pays) {
        return null;
    }
}
