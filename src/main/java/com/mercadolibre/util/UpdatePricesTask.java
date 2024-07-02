package com.mercadolibre.util;

import com.mercadolibre.domain.Product;
import com.mercadolibre.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UpdatePricesTask implements Runnable {
    private final List<Integer> ids;
    private final double value;
    private final ProductRepository productRepository;

    @Autowired
    public UpdatePricesTask(List<Integer> ids, double value, ProductRepository productRepository) {
        this.ids = ids;
        this.value = value;
        this.productRepository = productRepository;
    }

    @Override
    public void run() {
        for (Integer id : ids) {
            Product product = productRepository.findById(id).orElse(null);
            if (product != null) {
                product.setPrice(product.getPrice() + value);
                productRepository.save(product);
            }
        }
    }
}
