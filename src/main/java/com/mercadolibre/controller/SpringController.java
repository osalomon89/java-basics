package com.mercadolibre.controller;

import com.mercadolibre.controller.dtos.PriceDTO;
import com.mercadolibre.controller.dtos.ProductDTO;
import com.mercadolibre.controller.dtos.ProductResponseDTO;
import com.mercadolibre.controller.dtos.ProductsDataDTO;
import com.mercadolibre.domain.Product;
import com.mercadolibre.restclient.exception.RestException;
import com.mercadolibre.usecase.ApiException;
import com.mercadolibre.usecase.ProductUsecase;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SpringController {
	private static final Logger log = LoggerFactory.getLogger(SpringController.class);
	private ProductUsecase productService;

	private ModelMapper modelMapper;

	@Autowired
	public SpringController(ProductUsecase productService) {
		this.productService = productService;
		modelMapper = new ModelMapper();
	}

	@GetMapping("/ping")
	public ResponseEntity<?> Pong() {
		return new ResponseEntity<>("PONG", HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<ProductResponseDTO> saveProduct(@Valid @RequestBody ProductDTO productDto) {
		Product product = new Product();
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setType(productDto.getType());
		product.setProviderId(productDto.getProviderId());
		product.setStock(productDto.getStock());
		product.setPrice(productDto.getPrice());

		try {
			Product savedProduct = productService.saveProduct(product);
			ProductResponseDTO productResponseDTO = modelMapper.map(savedProduct, ProductResponseDTO.class);

			return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
		} catch (ApiException e){
			return new ResponseEntity<>(null, HttpStatusCode.valueOf(e.getStatusCode()));
		} catch (RestException e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/products-async")
	public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDTO productDto) {
		Product product = new Product();
		product.setCode(productDto.getCode());
		product.setDescription(productDto.getDescription());
		product.setType(productDto.getType());
		product.setProviderId(productDto.getProviderId());
		product.setStock(productDto.getStock());
		product.setPrice(productDto.getPrice());

		productService.createProductAsync(product);

		log.info("creating in progress.......");

		return new ResponseEntity<>("creating in progress", HttpStatus.ACCEPTED);
	}

	@GetMapping("/products/final-price")
	public ResponseEntity<PriceDTO> getFinalPrice(@RequestParam double price,
												  @RequestParam String discountType,
												  @RequestParam double discountValue) {
		double finalPrice = productService.getFinalPrice(price, discountType, discountValue);
		return new ResponseEntity<>(new PriceDTO(finalPrice), HttpStatus.OK);
	}

	@PutMapping("/products/price")
	public ResponseEntity<String> updatePrices(@RequestBody ProductsDataDTO data) {
		productService.updatePrices(data.getIdList(), data.getValue());


		log.info("updating in progress.......");

		return new ResponseEntity<>("Updating in progress", HttpStatus.ACCEPTED);
	}
}


