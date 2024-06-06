package com.mercadolibre.springBoot.src.main.java.com.example.springBoot.repositories;


import com.mercadolibre.springBoot.src.main.java.com.example.springBoot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
    void delete(ProductModel productModel);
}
