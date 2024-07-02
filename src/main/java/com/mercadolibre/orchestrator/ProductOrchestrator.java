package com.mercadolibre.orchestrator;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.steps.NotifyProductCreationStep;
import com.mercadolibre.pipeline.steps.SaveProductStep;
import com.mercadolibre.pipeline.steps.ValidateProductStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ProductOrchestrator {
    private static final Logger log = LoggerFactory.getLogger(ProductOrchestrator.class);

    private final ValidateProductStep validateStep;
    private final SaveProductStep saveStep;
    private final NotifyProductCreationStep notifyStep;

    public ProductOrchestrator(
            ValidateProductStep validateStep,
            SaveProductStep saveStep,
            NotifyProductCreationStep notifyStep) {
        this.validateStep = validateStep;
        this.saveStep = saveStep;
        this.notifyStep = notifyStep;
    }

    @Async
    public void createProduct(Product product) throws Exception {
        log.info("entering ProductOrchestrator");

        Product validatedProduct = validateStep.process(product);
        Product savedProduct = saveStep.process(validatedProduct);
        notifyStep.process(savedProduct);
    }
}
