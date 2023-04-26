package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.entites.Pays;

import java.util.List;

public interface PaysService {
    PaysDto CreatePays(PaysDto paysDto);
    PaysDto UpdatePays(String codePays, PaysDto paysDto);
    List<PaysDto> ListePays();
}
