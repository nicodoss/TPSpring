package com.nicodoss.tpspring.exceptions;

public class PaysNotFoundException extends RuntimeException {
    public PaysNotFoundException(String id){
       super("Le Pays avec le code" + id + "n'existe pas");
    }
}
