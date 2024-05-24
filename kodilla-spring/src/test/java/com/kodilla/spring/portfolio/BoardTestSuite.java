package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {

    @Test
    @DisplayName("Adding 1 exercise to every list with an access")
    void testTaskAdd() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        // When
        board.getToDoList().getTasks().add("Task to do");
        board.getInProgressList().getTasks().add("Task in progress");
        board.getDoneList().getTasks().add("Task done");

        // Then
        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals("Task to do", board.getToDoList().getTasks().get(0));
        assertEquals(1, board.getInProgressList().getTasks().size());
        assertEquals("Task in progress", board.getInProgressList().getTasks().get(0));
        assertEquals(1, board.getDoneList().getTasks().size());
        assertEquals("Task done", board.getDoneList().getTasks().get(0));
    }
}
