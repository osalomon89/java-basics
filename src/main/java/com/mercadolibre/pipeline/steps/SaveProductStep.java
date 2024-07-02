package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Step;
import com.mercadolibre.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class SaveProductStep implements Step<Product, Product> {
    private final ProductRepository productRepository;

    public SaveProductStep(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product process(Product input) {
        System.out.println("Step 2: SaveProductStep");
        return productRepository.save(input);
    }
}
