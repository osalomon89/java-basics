package com.mercadolibre.integration;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.mercadolibre.controller.SpringController;
import com.mercadolibre.controller.dtos.ProductDTO;
import com.mercadolibre.controller.dtos.ProductResponseDTO;
import com.mercadolibre.domain.Product;
import com.mercadolibre.factory.DiscountStrategyFactory;
import com.mercadolibre.repository.ProductRepository;
import com.mercadolibre.restclient.BrandClient;
import com.mercadolibre.usecase.ProductUsecase;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Transactional
public class SpringControllerTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        createProductDTOList(productDTOList);

        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        String url = "/api/v1/products/bulk";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<List<ProductDTO>> requestEntity = new HttpEntity<>(productDTOList, headers);

        ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Product[].class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(10, responseEntity.getBody().length);

        verify(productRepository, times(10)).save(any(Product.class));
    }

    private static void createProductDTOList(List<ProductDTO> products) {
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
