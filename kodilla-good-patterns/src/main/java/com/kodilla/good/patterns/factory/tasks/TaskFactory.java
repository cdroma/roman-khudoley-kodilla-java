package com.kodilla.good.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Food shopping", "Pineapple", 2);
            case PAINTING:
                return new PaintingTask("Car painting", "Red", "All car's outside metal elements");
            case DRIVING:
                return new DrivingTask("Vacation trip", "Santa Cruz", "Trailer");
            default:
                return null;
        }
    }
}
