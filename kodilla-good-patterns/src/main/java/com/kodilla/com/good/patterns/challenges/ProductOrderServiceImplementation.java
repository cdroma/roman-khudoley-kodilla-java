package com.kodilla.com.good.patterns.challenges;

public class ProductOrderServiceImplementation implements OrderService {
    @Override
    public boolean order(User user, Product product) {
        System.out.println("Ordering product: " + product.getProductName() + " for user: " + user.getName());
        return true;
    }
}
