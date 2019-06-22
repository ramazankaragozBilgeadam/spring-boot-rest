package com.bilgeadam.example.springbootrest.core;

public class KitapAdiNotFoundException extends RuntimeException {


    public KitapAdiNotFoundException (String message){
        super(message);
    }

}
