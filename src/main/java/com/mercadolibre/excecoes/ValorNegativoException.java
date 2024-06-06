package com.mercadolibre.excecoes;

public class ValorNegativoException extends RuntimeException {
    public ValorNegativoException(String msg) {
        super(msg);
    }
}
