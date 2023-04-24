package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.dtos.CompteClientDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompteClientController {
    @GetMapping(path = "/Clients/{TypePers}")
    public List<CompteClientDto> GetClientByTypePersonne(@PathVariable("TypePers")String typepers){
        List<CompteClientDto>listeClient=new ArrayList<>();
        return listeClient;

    }
}
