package com.mercadolibre.integration;

import com.mercadolibre.controller.SpringController;
import com.mercadolibre.controller.dtos.ProductDTO;
import com.mercadolibre.controller.dtos.ProductResponseDTO;
import com.mercadolibre.domain.Product;
import com.mercadolibre.factory.DiscountStrategyFactory;
import com.mercadolibre.orchestrator.ProductOrchestrator;
import com.mercadolibre.pipeline.steps.NotifyProductCreationStep;
import com.mercadolibre.pipeline.steps.SaveProductStep;
import com.mercadolibre.pipeline.steps.ValidateProductStep;
import com.mercadolibre.repository.ProductRepository;
import com.mercadolibre.restclient.BrandClient;
import com.mercadolibre.service.PipelineProductService;
import com.mercadolibre.usecase.ProductUsecase;
import com.mercadolibre.util.ExecutorThreadsPoolUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class WillProductControllerIntegrationTest {

    SpringController springController;

    @Mock
    ProductRepository productRepository;
    @Mock
    BrandClient brandClient;
    @Mock
    DiscountStrategyFactory discountStrategyFactory;
    @Mock
    ExecutorThreadsPoolUtils<Product> executorThreadsPoolUtils;
    private int idCounter = 1;

    @BeforeEach
    void setUp() {
        ValidateProductStep validateStep = new ValidateProductStep();
        NotifyProductCreationStep notifyStep = new NotifyProductCreationStep();
        SaveProductStep saveStep = new SaveProductStep(productRepository);
        PipelineProductService pipelineProductService = new PipelineProductService(validateStep,saveStep,notifyStep);
        ProductOrchestrator productOrchestrator = new ProductOrchestrator(validateStep,saveStep,notifyStep,pipelineProductService,executorThreadsPoolUtils );
        ProductUsecase productService = new ProductUsecase(productRepository,brandClient,discountStrategyFactory,productOrchestrator,executorThreadsPoolUtils);
        springController = new SpringController(productService);
    }
    @Test
    void testSaveProduct() {

        whenReturnRepositorySave();

        List<ProductDTO> products = new ArrayList<>();
        listProductos(products);
        ResponseEntity response =  springController.createBulkProducts(products);
        assertEquals("200 OK", response.getStatusCode().toString());
    }

    private void whenReturnRepositorySave() {
        when(productRepository.save(any())).thenReturn(Product.builder()
                        .id(1)
                        .code("P001")
                        .description("Product 1 Description")
                        .type("Type1")
                        .providerId(1)
                        .stock(100)
                        .price(99.99)
                        .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(2)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(3)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(4)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(5)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(6)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(7)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(8)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(9)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        when(productRepository.save(any())).thenReturn(Product.builder()
                .id(10)
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());


    }


    private static void listProductos(List<ProductDTO> products) {
        products.add(ProductDTO.builder()
                .code("P001")
                .description("Product 1 Description")
                .type("Type1")
                .providerId(1)
                .stock(100)
                .price(99.99)
                .build());

        products.add(ProductDTO.builder()
                .code("P002")
                .description("Product 2 Description")
                .type("Type2")
                .providerId(1)
                .stock(200)
                .price(199.99)
                .build());

        products.add(ProductDTO.builder()
                .code("P003")
                .description("Product 3 Description")
                .type("Type1")
                .providerId(2)
                .stock(150)
                .price(299.99)
                .build());

        products.add(ProductDTO.builder()
                .code("P004")
                .description("Product 4 Description")
                .type("Type3")
                .providerId(3)
                .stock(80)
                .price(89.49)
                .build());

        products.add(ProductDTO.builder()
                .code("P005")
                .description("Product 5 Description")
                .type("Type2")
                .providerId(2)
                .stock(60)
                .price(150.75)
                .build());

        products.add(ProductDTO.builder()
                .code("P006")
                .description("Product 6 Description")
                .type("Type1")
                .providerId(1)
                .stock(120)
                .price(45.00)
                .build());

        products.add(ProductDTO.builder()
                .code("P007")
                .description("Product 7 Description")
                .type("Type4")
                .providerId(4)
                .stock(300)
                .price(349.99)
                .build());

        products.add(ProductDTO.builder()
                .code("P008")
                .description("Product 8 Description")
                .type("Type3")
                .providerId(3)
                .stock(10)
                .price(199.00)
                .build());

        products.add(ProductDTO.builder()
                .code("P009")
                .description("Product 9 Description")
                .type("Type2")
                .providerId(4)
                .stock(50)
                .price(25.75)
                .build());

        products.add(ProductDTO.builder()
                .code("P010")
                .description("Product 10 Description")
                .type("Type4")
                .providerId(4)
                .stock(25)
                .price(499.99)
                .build());
    }
}