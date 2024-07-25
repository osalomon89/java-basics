package com.mercadolibre.usecase;

import com.mercadolibre.callable.ProductCallable;
import com.mercadolibre.domain.Product;
import com.mercadolibre.factory.DiscountStrategyFactory;
import com.mercadolibre.orchestrator.ProductOrchestrator;
import com.mercadolibre.strategy.product.IDiscountStrategy;
import com.mercadolibre.repository.ProductRepository;
import com.mercadolibre.restclient.BrandClient;
import com.mercadolibre.restclient.exception.RestException;
import com.mercadolibre.util.UpdatePricesTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.mercadolibre.util.ExecutorThreadsPoolUtils;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class ProductUsecase {
	private static final Logger log = LoggerFactory.getLogger(ProductUsecase.class);

	private final ProductRepository productRepository;
	private final BrandClient brandClient;
	private final DiscountStrategyFactory discountStrategyFactory;
	private final ExecutorService executorService = Executors.newFixedThreadPool(5);
	private final ProductOrchestrator productOrchestrator;
	private final ExecutorThreadsPoolUtils<Product> executorThreadsPoolUtils;

	public ProductUsecase(ProductRepository productRepository,
						  BrandClient brandClient,
						  DiscountStrategyFactory discountStrategyFactory,
						  ProductOrchestrator productOrchestrator,
						  ExecutorThreadsPoolUtils<Product> executorThreadsPoolUtils) {

		this.productRepository = productRepository;
		this.brandClient = brandClient;
		this.discountStrategyFactory = discountStrategyFactory;
		this.productOrchestrator = productOrchestrator;
		this.executorThreadsPoolUtils = executorThreadsPoolUtils;
	}

	public Product saveProduct(Product product) throws RestException {
		if (product.getStock() == 0){
			throw new ApiException("123", "stock cannot be null", 400);
		}

		boolean exist = brandClient.checkProvider(product.getProviderId());
		if (!exist){
			throw new ApiException("456", "invalid brand", 400);
		}

		return productRepository.save(product);
	}

	public void createProductAsync(Product product) {
		log.info("entering ProductUseCase");

		try {
			productOrchestrator.createProduct(product);
		} catch (Exception e){
			log.error("error creating product", e);
		}
	}

	public double getFinalPrice(double price, String discountType, double discountValue) {
		IDiscountStrategy strategy = discountStrategyFactory.getDiscountStrategy(discountType, discountValue);
		return strategy.applyDiscount(price);
	}

	@Async
	public void updatePrices(List<Integer> ids, double value) {
		log.info("entering updatePrices function");

		for (Integer id : ids) {
			Product product = productRepository.findById(id).orElse(null);
			if (product != null) {
				log.info("updating product ID: {}", id);
				product.setPrice(product.getPrice() + value);
				productRepository.save(product);
			}
		}
	}

	public void updatePricesTask(List<Integer> ids, double value) {
		log.info("entering updatePricesTask function");

		UpdatePricesTask task = new UpdatePricesTask(ids, value, productRepository);
		executorService.submit(task);
	}

	public List<Product> createBulkProducts(List<Product> products) {
		log.info("entering ProductUseCase: createBulkProducts().");

        return productOrchestrator.createProducts(products);
	}

	public List<Product> createProducts(List<Product> products){
		log.info("entering ProductUseCase: createProducts().");

		try{
			return executeThreads(products);
		} catch (Exception e) {
			log.error("error when execute simulation - {}", e.getMessage());
			return null;
		}
	}

	private List<Product> executeThreads(List<Product> products) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Callable<Product>> caseExecutorCallables = wrapProductOnCallable(products);
		List<Future<Product>> bulkCaseResults = executorService.invokeAll(caseExecutorCallables);
		executorService.shutdown();

		return executorThreadsPoolUtils.extractResponse(bulkCaseResults);
	}

	private List<Callable<Product>> wrapProductOnCallable(List<Product> products) {
		return products.parallelStream()
				.map(product -> (Callable<Product>) () -> productRepository.save(product))
				.collect(Collectors.toList());
	}
}








