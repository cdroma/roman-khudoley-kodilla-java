package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send," +
                    "but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }

    public class OptionalExample {
        public static void main(String[] args) {
            User user = new User("user1");

            Optional<User> optionalUser = Optional.ofNullable(user);

            optionalUser.ifPresent(u -> System.out.println(u.getName()));
        }
    }
}