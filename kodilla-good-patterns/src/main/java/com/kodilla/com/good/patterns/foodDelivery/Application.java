package com.kodilla.com.good.patterns.foodDelivery;

public class Application {
    public static void main(String[] args) {

        OrderProcessor extraFoodOrder = new OrderProcessor(new ExtraFoodShop());
        OrderProcessor healthyShopOrder = new OrderProcessor(new HealthyShop());
        OrderProcessor glutenFreeOrder = new OrderProcessor(new GlutenFreeShop());


        extraFoodOrder.executeOrder("Apples", 10);
        healthyShopOrder.executeOrder("Bananas", 20);
        glutenFreeOrder.executeOrder("Gluten-Free Bread", 5);
    }
}
