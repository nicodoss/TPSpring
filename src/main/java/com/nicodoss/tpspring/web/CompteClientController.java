package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.dtos.CompteClientDto;
import com.nicodoss.tpspring.enums.TypePersonne;
import com.nicodoss.tpspring.exceptions.CompteClientNotExistException;
import com.nicodoss.tpspring.mappers.CompteClientMappersImpl;
import com.nicodoss.tpspring.services.CompteClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RequestMapping("/clients")
@RestController
public class CompteClientController {
    @Autowired
    private  CompteClientService compteClientService;
    private CompteClientMappersImpl compteClientMappers;
    @GetMapping(path = "/{TypePers}")
    public List<CompteClientDto> getClientsByTypePers(@PathVariable("TypePers") TypePersonne typepers){
        List<CompteClientDto>listeClient= new ArrayList<CompteClientDto>();
        compteClientService.getComptesByTypePersonnes(typepers);
        return listeClient;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompteClientDto> updateClient(@PathVariable Long id, @RequestBody CompteClientDto updatedClient) throws CompteClientNotExistException {
        CompteClientDto  clt=compteClientService.UpdateCompteClients(id, updatedClient);
        return ResponseEntity.ok(clt);

    }
    @GetMapping("/getclientAll")
    public List<CompteClientDto> listeClientsAll(){
        return compteClientService.getAllCompteClients();
    }
    @GetMapping("/{NumCompte}")
    public CompteClientDto getCompteClient(@PathVariable String NumCompte){
        return compteClientService.GetCompteClientByNumCpte(NumCompte);
    }

    @PostMapping()
    public ResponseEntity<CompteClientDto> createClient(@RequestBody CompteClientDto clientDto){
        CompteClientDto clt=compteClientService.CreateCompteClient(clientDto);
        return ResponseEntity.ok(clt);

    }
}
