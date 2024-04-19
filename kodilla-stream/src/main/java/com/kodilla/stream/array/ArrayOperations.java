package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(i ->
                {System.out.println("Element" + " " + (i+1) + ": "
                            + numbers[i]);
                    return numbers[i];
                })
                .average()
                .ifPresent(avg -> System.out.println("Average:" + " " + avg));
        return IntStream.range(0, numbers.length)
                .mapToDouble(i -> numbers[i])
                .average()
                .orElse(0);
    }
}
