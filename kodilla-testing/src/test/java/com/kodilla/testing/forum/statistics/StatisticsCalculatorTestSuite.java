package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTestSuite {
    private StatisticsCalculator statisticsCalculator;
    private Statistics statisticsMock;

    @BeforeEach
    void setUp() {
        statisticsCalculator = new StatisticsCalculator();
        statisticsMock = Mockito.mock(Statistics.class);
    }

    @Test
    @DisplayName("Testing with 0 posts")
    void testCalculateAdvStatistics_WhenZeroPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User1"));

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, statisticsCalculator.getPostsCount());
        assertEquals(10, statisticsCalculator.getCommentsCount());
        assertEquals(0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(10.0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(0.0, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Testing with 1000 posts")
    void testCalculateAdvStatistics_WhenThousandPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User1"));

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(1000, statisticsCalculator.getPostsCount());
        assertEquals(500, statisticsCalculator.getCommentsCount());
        assertEquals(1000.0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(500.0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(0.5, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Testing with 0 comments")
    void testCalculateAdvStatistics_WhenZeroComments() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User1"));

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(20, statisticsCalculator.getPostsCount());
        assertEquals(0, statisticsCalculator.getCommentsCount());
        assertEquals(20.0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(0.0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(0.0, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Testing if there are more comments than posts")
    void testCalculateAdvStatistics_WhenMoreCommentsThanPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(150);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User1"));

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(100, statisticsCalculator.getPostsCount());
        assertEquals(150, statisticsCalculator.getCommentsCount());
        assertEquals(100.0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(150.0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(1.5, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Testing with 0 users")
    void testCalculateAdvStatistics_WhenZeroUsers() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, statisticsCalculator.getUsersCount());
        assertEquals(50, statisticsCalculator.getPostsCount());
        assertEquals(100, statisticsCalculator.getCommentsCount());
        assertEquals(0.0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(0.0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(2.0, statisticsCalculator.getAvgCommentsPerPost());
    }

    @Test
    @DisplayName("Testing with 100 users")
    void testCalculateAdvStatistics_WhenHundredUsers() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(300);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(100, "User"));

        // When
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(100, statisticsCalculator.getUsersCount());
        assertEquals(200, statisticsCalculator.getPostsCount());
        assertEquals(300, statisticsCalculator.getCommentsCount());
        assertEquals(2.0, statisticsCalculator.getAvgPostsPerUser());
        assertEquals(3.0, statisticsCalculator.getAvgCommentsPerUser());
        assertEquals(1.5, statisticsCalculator.getAvgCommentsPerPost());
    }
}
