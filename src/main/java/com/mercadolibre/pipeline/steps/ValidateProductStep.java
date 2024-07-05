package com.mercadolibre.pipeline.steps;

import com.mercadolibre.domain.Product;
import com.mercadolibre.exceptions.ProductProcessingExceptions;
import com.mercadolibre.pipeline.Step;
import com.mercadolibre.util.ValidateInputUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class ValidateProductStep implements Step<Product, Product> {
    @Override
    public Product process(Product input) throws Exception {
        try {
            ValidateInputUtils.validateNotNull(input.getDescription());
            ValidateInputUtils.validateNotNull(input.getPrice());
            System.out.println("Product Valid: " + input.getDescription());
        }catch (Exception e){
            System.out.println("Product not Valid" );
            throw new ProductProcessingExceptions.ValidateProductException("Not valid products", e);
        }

        return input;
    }
}
