package com.kodilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Patterns2Application {
    public static void main(String[] args) {
        SpringApplication.run(Patterns2Application.class, args);
    }
}