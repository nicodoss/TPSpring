package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.exceptions.PaysNotFoundException;
import com.nicodoss.tpspring.exceptions.RowsVersionsChangingExceptions;
import com.nicodoss.tpspring.mappers.PaysMappers;
import com.nicodoss.tpspring.repositories.PaysRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

        PaysDto paysDto =paysMappers.modelToDto(paysRepository.findById(codePays).orElseThrow(()->new PaysNotFoundException(codePays)));
        //Si la version qui est en cours de modification n'est pas la même levé une exception.
        if(paysDto.getRowversions()!=pays.getRowversions()){
            throw new RowsVersionsChangingExceptions("Pays");
        }
        return paysMappers.modelToDto(paysRepository.save(paysMappers.dtoToModel(pays)));
    }

    @Override
    public List<PaysDto> ListePays() {
        return paysRepository.findAll().stream().map((element)->paysMappers.modelToDto(element)).collect(Collectors.toList());
    }
}
