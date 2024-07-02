package com.mercadolibre.restclient;

import com.mercadolibre.restclient.MeliRESTPool;
import com.mercadolibre.restclient.MeliRestClient;
import com.mercadolibre.restclient.RESTPool;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.exception.RestException;
import com.mercadolibre.restclient.util.MeliContextBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BrandClientImpl implements BrandClient{
    private MeliRestClient restClient;

    public BrandClientImpl() throws IOException {
        RESTPool aPool = MeliRESTPool.builder()
                .withName("my_pool")
                .build();

        this.restClient = MeliRestClient.builder()
                .withPool(aPool)
                .build();
    }

    public boolean checkProvider(Integer id) throws RestException {
        String url = String.format("https://jsonplaceholder.typicode.com/posts/%d",id);

        var meliContext = MeliContextBuilder.buildFlowStarterContext();

        Response response = restClient.get(url, meliContext);

        if (response.getStatus() != 200){
            return false;
        }

        return true;
    }
}
