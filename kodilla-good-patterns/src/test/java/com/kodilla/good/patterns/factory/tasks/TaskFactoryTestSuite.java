package com.kodilla.good.patterns.factory.tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    @DisplayName("Testing shopping task")
    void testFactoryShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();

        // Then
        assertEquals("Food shopping", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    @DisplayName("Testing painting tasks")
    void testFactoryPaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        painting.executeTask();

        // Then
        assertEquals("Car painting", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    @DisplayName("Testing driving task")
    void testFactoryDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        driving.executeTask();

        // Then
        assertEquals("Vacation trip", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
