package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Step;
import org.springframework.stereotype.Component;

@Component
public class NotifyProductCreationStep implements Step<Product, Void> {
    @Override
    public Void process(Product input) {
        System.out.println("Step 3: NotifyProductCreationStep");
        System.out.println("Product created: " + input.getDescription());
        return null;
    }
}
