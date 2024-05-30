package com.kodilla.good.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    @DisplayName("Testing log from class Logger")
    void testLog() {
        // Given
        Logger logger = Logger.INSTANCE;
        String logMessage = "Test log";

        // When
        logger.log(logMessage);
        String result = logger.getLastLog();

        // Then
        Assertions.assertEquals(logMessage, result);
    }

    @Test
    @DisplayName("Testing getLastLog from class Logger ")
    void testGetLastLog() {
        // Given
        Logger logger = Logger.INSTANCE;
        String logMessage1 = "First log";
        String logMessage2 = "Second log";

        // When
        logger.log(logMessage1);
        logger.log(logMessage2);
        String result = logger.getLastLog();

        // Then
        Assertions.assertEquals(logMessage2, result);
    }
}
