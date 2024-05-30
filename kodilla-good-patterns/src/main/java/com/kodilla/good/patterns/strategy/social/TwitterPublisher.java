package com.kodilla.good.patterns.strategy.social;

public class TwitterPublisher implements  SocialPublisher {
    @Override
    public String share() {
        return "This user uses Twitter";
    }
}
