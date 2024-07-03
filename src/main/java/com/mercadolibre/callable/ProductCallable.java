package com.mercadolibre.callable;

import com.mercadolibre.domain.Product;
import com.mercadolibre.service.PipelineProductService;
import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class ProductCallable implements Callable<Product> {
    private final Product product;
    private final PipelineProductService pipelineProductService;

    @Override
    public Product call() {
        return pipelineProductService.createProduct(this.product);
    }
}
