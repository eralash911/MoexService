package com.eralash.moexservice.exeption;

public class BondParsingException extends RuntimeException{
    public  BondParsingException(Exception ex){
        super(ex);
    }
}
