package com.example.lab8_673380278_9_sec1.strategy;

public class DiscountContext {

    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double price) {
        return strategy.calculate(price);
    }
}