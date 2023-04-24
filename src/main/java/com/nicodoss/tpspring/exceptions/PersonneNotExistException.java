package com.nicodoss.tpspring.exceptions;

public class PersonneNotExistException extends Exception{
    public PersonneNotExistException(Long persid) {

        super("La personne avec l'id " + persid + "n'existe pas");
    }
}
