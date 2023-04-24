package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.dtos.PaysDto;
import com.nicodoss.tpspring.entites.Pays;

public interface PaysService {
    PaysDto CreatePays(PaysDto paysDto);
    PaysDto UpdatePays(String codePays, PaysDto paysDto);
}
