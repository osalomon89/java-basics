package com.mercadolibre.orchestrator;

import com.mercadolibre.domain.Product;
import com.mercadolibre.exceptions.ProductProcessingExceptions;
import com.mercadolibre.pipeline.Pipeline;
import com.mercadolibre.pipeline.steps.NotifyProductCreationStep;
import com.mercadolibre.pipeline.steps.SaveProductStep;
import com.mercadolibre.pipeline.steps.ValidateProductStep;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductOrchestrator {
    private static final Logger log = LoggerFactory.getLogger(ProductOrchestrator.class);
    private final ValidateProductStep validateProductStep;
    private final SaveProductStep saveProductStep;
    private final NotifyProductCreationStep notifyProductCreationStep;

    @Async
    public void createProduct(Product product) throws Exception {
        log.info("entering ProductOrchestrator");
        try {
            Pipeline<Product, Product> pipeline = new Pipeline<>(validateProductStep)
                    .pipe(saveProductStep)
                    .pipe(notifyProductCreationStep);

            pipeline.execute(product);
        }catch (ProductProcessingExceptions.ValidateProdutoException e){
            System.out.println("Product not Valid" );
        }catch (ProductProcessingExceptions.SaveProductException e){
            System.out.println("Product not Saved" );
        }
    }
}
