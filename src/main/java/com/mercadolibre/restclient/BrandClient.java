package com.mercadolibre.restclient;

import com.mercadolibre.restclient.exception.RestException;

public interface BrandClient {
    boolean checkProvider(Integer id) throws RestException;
}
