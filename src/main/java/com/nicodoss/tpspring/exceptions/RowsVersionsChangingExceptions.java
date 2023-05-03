package com.nicodoss.tpspring.exceptions;

public class RowsVersionsChangingExceptions extends RuntimeException{
    public RowsVersionsChangingExceptions(String entity){
        super("La ligne "+ entity+ " que vous avez sélectionné est déjà modifiée.Prière actualiser la page");
    }
}
