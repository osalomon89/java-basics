package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Step;
import org.springframework.stereotype.Component;

@Component
public class NotifyProductCreationStep implements Step<Product, Product> {
    @Override
    public Product process(Product input) {
        System.out.println("Step 3: NotifyProductCreationStep");
        System.out.println("Product ID: " + input.getId());
        System.out.println("Product date: " + input.getCreatedAt());
        return input;
    }
}
