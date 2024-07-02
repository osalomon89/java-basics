package com.mercadolibre.factory;

import com.mercadolibre.product.FixedAmountDiscount;
import com.mercadolibre.product.IDiscountStrategy;
import com.mercadolibre.product.NoDiscount;
import com.mercadolibre.product.PercentageDiscount;
import org.springframework.stereotype.Component;

@Component
public class DiscountStrategyFactory {
    public IDiscountStrategy getDiscountStrategy(String type, double value) {
        switch (type) {
            case "NONE":
                return new NoDiscount();
            case "PERCENTAGE":
                return new PercentageDiscount(value);
            case "FIXED":
                return new FixedAmountDiscount(value);
            default:
                throw new IllegalArgumentException("Unknown discount type");
        }
    }
}
