package com.kodilla.good.patterns.foodDelivery;

public class OrderProcessor {
    private Producer producer;

    public OrderProcessor(Producer producer) {
        this.producer = producer;
    }

    public boolean executeOrder(String product, int quantity) {
        System.out.println("Starting order for " + quantity + " items of " + product);
        boolean success = producer.process(product, quantity);
        if (success) {
            System.out.println("Order for " + quantity + " x " + product + " was successful");
        } else {
            System.out.println("Order for " + quantity + " x " + product + " failed");
        }
        return success;
    }
}
