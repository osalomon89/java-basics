package com.mercadolibre.pipeline;

public interface Step<I, O> {
    O process(I input) throws Exception;
}