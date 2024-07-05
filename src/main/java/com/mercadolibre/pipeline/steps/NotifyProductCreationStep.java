package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Step;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class NotifyProductCreationStep implements Step<Product, Product>  {
    @Override
    public Product process(Product input){
        System.out.println("Product created: " + input.getDescription());
        return input;
    }
}
