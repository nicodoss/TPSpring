package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.dtos.CompteClientDto;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.services.CompteClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompteClientController {
    @Autowired
    private  CompteClientService compteClientService;
    @GetMapping(path = "/Clients/{TypePers}")
    public List<CompteClientDto> GetClientByTypePersonne(@PathVariable("TypePers") TypePersonne typepers){
        List<CompteClientDto>listeClient= new ArrayList<CompteClientDto>();
        compteClientService.getComptesByTypePersonnes(typepers);
        return listeClient;
    }

}
