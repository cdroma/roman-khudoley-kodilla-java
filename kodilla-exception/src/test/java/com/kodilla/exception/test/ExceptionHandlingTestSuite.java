package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTestSuite {

    @Test
    @DisplayName("Testing X == 2 & Y == 1.5")
    void shouldThrowExceptionWhenXEquals2YEquals1_5() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();

        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5));
    }

    @Test
    @DisplayName("Testing X > 2 & Y == 1.5")
    void shouldThrowExceptionWhenXIsGreaterThan2Yequals1_5() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();

        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3, 1.5));
    }

    @Test
    @DisplayName("Testing X < 2 & Y != 1.5")
    void shouldReturnDoneWhenXIsLessThan2YnotEquals1_5() throws Exception {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();

        // when
        String result = secondChallenge.probablyIWillThrowException(1, 1);

        // then
        assertEquals("Done!", result);
    }

    @Test
    @DisplayName("Testing X > 1 & X < 2 & Y != 1.5")
    void shouldReturnDoneWhenXIsGreaterThan1AndLessThan2YnotEquals1_5() throws Exception {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();

        // when
        String result = secondChallenge.probablyIWillThrowException(1.5, 0.5);

        // then
        assertEquals("Done!", result);
    }
}
