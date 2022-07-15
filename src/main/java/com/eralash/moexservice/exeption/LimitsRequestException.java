package com.eralash.moexservice.exeption;

public class LimitsRequestException extends RuntimeException{
    public LimitsRequestException(String msg){
        super(msg);
    }
}
