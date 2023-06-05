package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.CompteClientDto;
import com.nicodoss.tpspring.entites.CompteClient;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.exceptions.CompteClientNotExistException;
import com.nicodoss.tpspring.exceptions.RowsVersionsChangingExceptions;
import com.nicodoss.tpspring.mappers.CompteClientMappers;
import com.nicodoss.tpspring.repositories.CompteClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteClientServiceImpl implements CompteClientService {
    @Autowired
    private CompteClientRepository compteClientRepository;
    @Autowired
    private CompteClientMappers compteClientMappers;

    @Override
    public CompteClientDto CreateCompteClient(CompteClientDto cpt) {
        CompteClient cptclient = compteClientMappers.DtoToModel(cpt);
        compteClientRepository.save(cptclient);
        return cpt;
    }

    @Override
    public List<CompteClientDto> getAllCompteClients() {
        List<CompteClientDto> lstCpte = new ArrayList<>();
        lstCpte = compteClientRepository.findAll().stream().map((element) -> compteClientMappers.ModelToDto(element)).collect(Collectors.toList());
        return lstCpte;
    }

    @Override
    public List<CompteClientDto> getComptesByTypePersonnes(TypePersonne typePersonne) {
        List<CompteClientDto> lstCpte = new ArrayList<>();
        lstCpte = compteClientRepository.FindCompteByTypePers(typePersonne).stream().map((element) -> compteClientMappers.ModelToDto(element)).collect(Collectors.toList());
        return lstCpte;
    }

    @Override
    public CompteClientDto getCompteClientById(Long id) throws CompteClientNotExistException {
        return compteClientMappers.ModelToDto(compteClientRepository.findById(id).orElseThrow(() -> new CompteClientNotExistException(id)));
    }

    @Override
    public CompteClientDto UpdateCompteClients(Long id, CompteClientDto cpte) throws CompteClientNotExistException {
        CompteClient clt = compteClientRepository.findById(id).orElseThrow(() -> new CompteClientNotExistException(id));
        if (clt.getRowversions() != cpte.getRowversions())
            throw new RowsVersionsChangingExceptions("Client");

        CompteClient cltupdate = compteClientMappers.DtoToModel(cpte);
        clt.setIntituleCompte(cltupdate.getIntituleCompte());
        clt.setAbrege(cltupdate.getAbrege());
        clt.setListePersonne(cltupdate.getListePersonne());
        return compteClientMappers.ModelToDto(compteClientRepository.save(clt));

    }

    @Override
    public void DeleteCompteClient(CompteClientDto cpte) {
        compteClientRepository.delete(compteClientMappers.DtoToModel(cpte));
    }

    @Override
    public CompteClientDto GetCompteClientByNumCpte(String Numcompte) {
        return compteClientMappers.ModelToDto(compteClientRepository.findByNumCompte(Numcompte));
    }
}
