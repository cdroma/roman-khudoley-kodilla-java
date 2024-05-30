package com.kodilla.good.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "This user uses Snapchat";
    }
}
