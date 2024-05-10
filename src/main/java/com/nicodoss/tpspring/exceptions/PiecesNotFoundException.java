package com.nicodoss.tpspring.exceptions;

public class PiecesNotFoundException extends Exception{
    public PiecesNotFoundException(Long id){
        super("Le Pays avec le code" + id + "n'existe pas");
    }
}
