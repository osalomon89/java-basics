package com.mercadolibre.integration;

import com.mercadolibre.controller.dtos.ProductDTO;
import com.mercadolibre.controller.dtos.ProductResponseDTO;
import com.mercadolibre.domain.Product;
import com.mercadolibre.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Transactional
class ProductControllerIntegrationTest {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }

    @Test
    void testSaveProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("P001");
        productDTO.setDescription("Product 1 Description");
        productDTO.setType("Type1");
        productDTO.setProviderId(1);
        productDTO.setStock(100);
        productDTO.setPrice(99.99);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        RequestEntity<ProductDTO> request = new RequestEntity<>(productDTO, headers, HttpMethod.POST, null);

        ResponseEntity<ProductResponseDTO> response =
                this.testRestTemplate.exchange(
                        "/api/v1/products", HttpMethod.POST,
                        request,
                        ProductResponseDTO.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNotNull(response.getBody());

        ProductResponseDTO responseBody = response.getBody();
        Product savedProduct = productRepository.findById(responseBody.getId()).orElse(null);

        assertNotNull(savedProduct);
        assertEquals(savedProduct.getCode(), responseBody.getCode());
        assertEquals(savedProduct.getDescription(), responseBody.getDescription());
    }
}