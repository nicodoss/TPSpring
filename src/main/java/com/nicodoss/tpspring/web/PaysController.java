package com.nicodoss.tpspring.web;

import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.services.PaysService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
public class PaysController {
    private PaysService paysService;

    @PostMapping("/create")
    public PaysDto CreatePays(@RequestBody PaysDto pays) {
        return paysService.CreatePays(pays);
    }
    @GetMapping("/getAll")
    public List<PaysDto> ListePays() {
        return paysService.ListePays();
    }
    @PutMapping("update/{code}")
    public ResponseEntity<PaysDto> update(@PathVariable String code, @RequestBody PaysDto paysDto){
        PaysDto paysDtos=paysService.UpdatePays(code,paysDto);
        return ResponseEntity.ok(paysDto);
    }
}
