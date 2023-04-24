package com.nicodoss.tpspring.services;


import com.nicodoss.tpspring.dtos.CompteClientDto;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.exceptions.CompteClientNotExistException;

import java.util.List;

public interface CompteClientService {
    CompteClientDto CreateCompteClient(CompteClientDto cpt);
    List<CompteClientDto> getAllCompteClients();
    List<CompteClientDto>getComptesByTypePersonnes(TypePersonne typePersonne);
    CompteClientDto getCompteClientById(Long id) throws CompteClientNotExistException;
    CompteClientDto UpdateCompteClients(CompteClientDto cpte);
    void DeleteCompteClient(CompteClientDto cpte);
    CompteClientDto GetCompteClientByNumCpte(String Numcompte);
}
