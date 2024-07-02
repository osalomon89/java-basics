package com.mercadolibre.strategy.product;

public class NoDiscount implements IDiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
