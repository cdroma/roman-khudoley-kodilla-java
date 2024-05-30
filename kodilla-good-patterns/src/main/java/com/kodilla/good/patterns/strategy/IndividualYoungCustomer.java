package com.kodilla.good.patterns.strategy;

import com.kodilla.good.patterns.strategy.predictors.AggressivePredictor;

public class IndividualYoungCustomer extends Customer {

    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
}
