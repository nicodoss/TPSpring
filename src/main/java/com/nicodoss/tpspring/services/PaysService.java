package com.nicodoss.tpspring.services;

import com.nicodoss.tpspring.entites.Pays;

public interface PaysService {
    Pays CreatePays(Pays pays);
    Pays UpdatePays(String codePays, Pays pays);
}
