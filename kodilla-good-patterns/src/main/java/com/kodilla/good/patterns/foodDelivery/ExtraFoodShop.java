package com.kodilla.good.patterns.foodDelivery;

public class ExtraFoodShop implements Producer {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in ExtraFoodShop: " + quantity + " x " + product);

        return true;
    }
}

