package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.exceptions.ProductProcessingExceptions;
import com.mercadolibre.pipeline.Step;
import com.mercadolibre.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class SaveProductStep implements Step<Product, Product> {

    private final ProductRepository productRepository;
    @Override
    public Product process(Product input) throws Exception {
        try {
            productRepository.save(input);
            System.out.println("Product created: " + input.getDescription());
        }catch (Exception e){
            System.out.println("Product created: ");
            throw new ProductProcessingExceptions.SaveProductException("Not saved products", e);
        }
        return input;
    }
}
