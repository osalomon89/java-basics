package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Step;
import org.springframework.stereotype.Component;

@Component
public class ValidateProductStep implements Step<Product, Product> {
    @Override
    public Product process(Product input) {
        System.out.println("Step 1: ValidateProductStep");

        if (input.getCode() == null || input.getCode().isEmpty()) {
            throw new IllegalArgumentException("Product code is required");
        }

        if (input.getDescription() == null || input.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Product description is required");
        }

        if (input.getType() == null || input.getType().isEmpty()) {
            throw new IllegalArgumentException("Product type is required");
        }

        return input;
    }
}
