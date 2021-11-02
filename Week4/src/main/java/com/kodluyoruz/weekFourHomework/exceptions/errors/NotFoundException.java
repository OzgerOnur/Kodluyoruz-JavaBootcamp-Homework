package com.kodluyoruz.weekFourHomework.exceptions.errors;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Not Found");
    }
    public NotFoundException(String msg){
        super(msg);
    }
}
