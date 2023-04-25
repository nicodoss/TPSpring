package com.nicodoss.tpspring.web;
import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.services.PaysService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor @RestController
@RequestMapping("/Pays")
public class PaysController {
    private PaysService paysService;

    @PostMapping("/create")
    public PaysDto CreatePays(@RequestBody PaysDto pays){
        return paysService.CreatePays(pays);
    }
}
