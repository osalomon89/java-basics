package com.mercadolibre.product;

public class FixedAmountDiscount implements IDiscountStrategy {
    private final double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - amount;
    }
}
