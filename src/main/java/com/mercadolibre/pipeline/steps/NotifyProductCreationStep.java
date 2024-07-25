package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotifyProductCreationStep implements Step<Product, Product> {
    private static final Logger log = LoggerFactory.getLogger(NotifyProductCreationStep.class);

    @Override
    public Product process(Product input) {
        log.info("Step 3: NotifyProductCreationStep");
        log.info("Product ID: {}", input.getId());
        log.info("Product date: {}", input.getCreatedAt());
        return input;
    }
}
