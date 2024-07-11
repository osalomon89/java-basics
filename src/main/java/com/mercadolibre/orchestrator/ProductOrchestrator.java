package com.mercadolibre.orchestrator;

import com.mercadolibre.callable.ProductCallable;
import com.mercadolibre.domain.Product;
import com.mercadolibre.pipeline.Pipeline;
import com.mercadolibre.pipeline.steps.NotifyProductCreationStep;
import com.mercadolibre.pipeline.steps.SaveProductStep;
import com.mercadolibre.pipeline.steps.ValidateProductStep;
import com.mercadolibre.service.PipelineProductService;
import com.mercadolibre.util.ExecutorThreadsPoolUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductOrchestrator {
    private static final Logger log = LoggerFactory.getLogger(ProductOrchestrator.class);

    private final ValidateProductStep validateStep;
    private final SaveProductStep saveStep;
    private final NotifyProductCreationStep notifyStep;
    private final PipelineProductService pipelineProductService;
    private final ExecutorThreadsPoolUtils<Product> executorThreadsPoolUtils;

    @Async
    public void createProduct(Product product) throws Exception {
        log.info("entering ProductOrchestrator");

        Pipeline<Product, Product> pipeline =  new Pipeline<>(validateStep)
                .pipe(saveStep)
                .pipe(notifyStep);

        pipeline.execute(product);
    }

    @Async
    public CompletableFuture<Void> orchestrate(Product product) {
        return CompletableFuture.supplyAsync(() -> validateStep.process(product))
                .thenApplyAsync(saveStep::process)
                .thenAcceptAsync(notifyStep::process);
    }

    public List<Product> createProducts(List<Product> products){
        try{
            return executeThreads(products);
        } catch (Exception e) {
            log.error("error when execute simulation - {}", e.getMessage());
            return null;
        }
    }

    private List<Product> executeThreads(List<Product> products) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<ProductCallable> caseExecutorCallables = wrapProductOnCallable(products);
        List<Future<Product>> bulkCaseResults = executorService.invokeAll(caseExecutorCallables);
        executorService.shutdown();

        return executorThreadsPoolUtils.extractResponse(bulkCaseResults);
    }

    private List<ProductCallable> wrapProductOnCallable(List<Product> products) {
        return products.parallelStream()
                .map(data -> new ProductCallable(data, pipelineProductService))
                .collect(Collectors.toList());
    }
}
