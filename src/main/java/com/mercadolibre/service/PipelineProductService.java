package com.mercadolibre.service;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Pipeline;
import com.mercadolibre.pipeline.steps.NotifyProductCreationStep;
import com.mercadolibre.pipeline.steps.SaveProductStep;
import com.mercadolibre.pipeline.steps.ValidateProductStep;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Slf4j
@Service
@AllArgsConstructor
public class PipelineProductService {
    private final ValidateProductStep validateStep;
    private final SaveProductStep saveStep;
    private final NotifyProductCreationStep notifyStep;

    @Transactional
    public Product createProduct(Product product) {
        try {
            Pipeline<Product, Product> pipeline =  new Pipeline<>(validateStep)
                    .pipe(saveStep)
                    .pipe(notifyStep);

            return pipeline.execute(product);
        }catch (Exception e){
            log.info("error while execute creating pipeline", e);
            return null;
        }
    }
}
