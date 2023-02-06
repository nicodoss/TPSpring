package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.entites.Pays;
import com.nicodoss.tpspring.services.PaysService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor @RestController

public class PaysController {
    private PaysService paysService;
    @PostMapping("/CreatePays")
    public Pays CreatePays(@RequestBody Pays pays){
        return paysService.CreatePays(pays);
    }
}
