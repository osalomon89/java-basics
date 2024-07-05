package com.mercadolibre.util;

import com.mercadolibre.exceptions.ProductProcessingExceptions;
import com.mercadolibre.service.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;


@Slf4j
@Component
public class ValidateInputUtils {

    public static void validateNotNull(Object... inputs) throws Exception {
        for (Object input : inputs) {
            if (input == null) {
                log.error("Invalid input: inputs must be non-null");
                throw new ProductProcessingExceptions.ValidateProductException("All inputs must be non-null");
            }

            if (input instanceof Collection && ((Collection<?>) input).isEmpty()) {
                log.error("Invalid input: Collections must not be empty");
                throw new ProductProcessingExceptions.ValidateProductException("Collections must not be empty");
            }
        }
    }

}
