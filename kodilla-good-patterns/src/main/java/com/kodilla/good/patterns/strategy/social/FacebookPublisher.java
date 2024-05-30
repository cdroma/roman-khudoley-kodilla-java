package com.kodilla.good.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "This user uses Facebook";
    }
}
