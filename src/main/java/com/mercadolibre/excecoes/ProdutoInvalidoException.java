package com.mercadolibre.excecoes;

public class ProdutoInvalidoException extends RuntimeException {
    public ProdutoInvalidoException(String msg) {
        super(msg);
    }
}
