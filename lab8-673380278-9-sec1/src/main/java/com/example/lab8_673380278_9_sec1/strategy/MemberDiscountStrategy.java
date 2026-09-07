package com.example.lab8_673380278_9_sec1.strategy;

public class MemberDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}