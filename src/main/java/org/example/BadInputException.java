package org.example;


public class BadInputException extends Exception{
    String e;

    BadInputException(String e){
        this.e = e;
    }

    public String toString(){
        return e;
    }
}
