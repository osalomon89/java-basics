package com.mercadolibre.product;

public class PercentageDiscount implements IDiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - percentage / 100);
    }
}
