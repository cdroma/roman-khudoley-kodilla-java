package com.kodilla.good.patterns.strategy;

import com.kodilla.good.patterns.strategy.predictors.BalancedPredictor;
public class CorporateCustomer extends Customer {

    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
