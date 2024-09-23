package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MentorObserverTestSuite {

    @Test
    void testUpdate() {
        // Given
        StudentTaskQueue student1Tasks = new StudentTaskQueue("John Doe");
        StudentTaskQueue student2Tasks = new StudentTaskQueue("Jane Smith");
        StudentTaskQueue student3Tasks = new StudentTaskQueue("Tom Hardy");

        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");

        student1Tasks.registerObserver(mentor1);
        student2Tasks.registerObserver(mentor1);
        student3Tasks.registerObserver(mentor2);

        // When
        student1Tasks.addTask("Task 1");
        student1Tasks.addTask("Task 2");
        student2Tasks.addTask("Task 1");
        student3Tasks.addTask("Task 1");

        // Then
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(1, mentor2.getUpdateCount());
    }
}
