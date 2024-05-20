package com.kodilla.com.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;
public class Application {
    public static void main(String[] args){

        MovieStore movieStore =new MovieStore();

        String result = movieStore.getMovies().values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining(" ! "));

        System.out.println(result);
    }
}
