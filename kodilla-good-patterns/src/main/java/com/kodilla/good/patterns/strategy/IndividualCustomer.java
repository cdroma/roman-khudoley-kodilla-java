package com.kodilla.good.patterns.strategy;

import com.kodilla.good.patterns.strategy.predictors.ConservativePredictor;

public class IndividualCustomer extends Customer {

    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor();
    }
}
