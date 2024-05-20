package com.kodilla.com.good.patterns.challenges;

public class EmailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Sending an email to:\n " + user.getEmail());
    }
}
