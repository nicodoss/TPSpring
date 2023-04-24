package com.nicodoss.tpspring.exceptions;

public class CompteClientNotExistException extends Exception{
    public CompteClientNotExistException(Long id){
        super("Le compte client avec l'id " + id + "n'existe pas");
    }
}
