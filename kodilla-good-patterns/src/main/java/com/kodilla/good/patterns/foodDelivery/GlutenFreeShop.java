package com.kodilla.good.patterns.foodDelivery;

public class GlutenFreeShop implements Producer {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in GlutenFreeShop: " + quantity + " x " + product);

        return true;
    }
}
