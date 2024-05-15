package com.mercadolibre.ececoes;

public class IdadeInvalidaException extends Exception {
    public IdadeInvalidaException (int idade){
        if (idade<=0 || idade>=120){


        }
    }
}
