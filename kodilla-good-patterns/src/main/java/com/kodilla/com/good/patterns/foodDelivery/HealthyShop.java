package com.kodilla.com.good.patterns.foodDelivery;

public class HealthyShop implements Producer {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("Processing order in HealthyShop: " + quantity + " x " + product);
        // Symulacja przetwarzania zamówienia
        return true;
    }
}
