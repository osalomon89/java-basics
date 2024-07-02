package com.mercadolibre.orchestrator;

import com.mercadolibre.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ProductOrchestrator {
    private static final Logger log = LoggerFactory.getLogger(ProductOrchestrator.class);

    public ProductOrchestrator() { }

    @Async
    public void createProduct(Product product) throws Exception {
        log.info("entering ProductOrchestrator");
    }
}
