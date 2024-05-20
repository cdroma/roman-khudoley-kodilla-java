package com.kodilla.com.good.patterns.challenges;

public class OrderRepositoryImplementation implements OrderRepository {
    @Override
    public void createOrder(User user, Product product) {
        System.out.println("Creating order: " + product.getProductName() + " | "+ "for user: " + user.getName());
    }
}
