package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.dtos.CompteClientDto;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.exceptions.CompteClientNotExistException;
import com.nicodoss.tpspring.services.CompteClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/clients")
@RestController
public class CompteClientController {
    @Autowired
    private  CompteClientService compteClientService;

    @GetMapping(path = "/{TypePers}")
    public List<CompteClientDto> getClientsByTypePers(@PathVariable("TypePers") TypePersonne typepers){
        List<CompteClientDto>listeClient= new ArrayList<CompteClientDto>();
        compteClientService.getComptesByTypePersonnes(typepers);
        return listeClient;
    }
    @PutMapping("/{id}")
    public CompteClientDto updateClient(@PathVariable Long id, @RequestBody CompteClientDto updatedClient) throws CompteClientNotExistException {
        return compteClientService.UpdateCompteClients(id, updatedClient);
    }

}
