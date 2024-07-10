import com.mercadolibre.controller.SpringController;
import com.mercadolibre.factory.DiscountStrategyFactory;
import com.mercadolibre.orchestrator.ProductOrchestrator;
import com.mercadolibre.pipeline.steps.NotifyProductCreationStep;
import com.mercadolibre.pipeline.steps.SaveProductStep;
import com.mercadolibre.pipeline.steps.ValidateProductStep;
import com.mercadolibre.repository.ProductRepository;
import com.mercadolibre.restclient.BrandClient;
import com.mercadolibre.restclient.exception.RestException;
import com.mercadolibre.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Map;

public class SpringControllerTest {
    SpringController springController;

    @Mock
    ProductRepository productRepository;

    @Mock
    BrandClient brandClient;
    @BeforeEach
    void setUp() {
        ValidateProductStep validateProductStep = new ValidateProductStep();
        SaveProductStep saveProductStep = new SaveProductStep(productRepository);
        NotifyProductCreationStep notifyProductCreationStep = new NotifyProductCreationStep();
        ProductOrchestrator productOrchestrator = new ProductOrchestrator(validateProductStep,saveProductStep,notifyProductCreationStep);
        DiscountStrategyFactory discountStrategyFactory = new DiscountStrategyFactory();
        ProductService productService = new ProductService(productRepository,brandClient,discountStrategyFactory,productOrchestrator);
        springController = new SpringController(productService);
    }

}
