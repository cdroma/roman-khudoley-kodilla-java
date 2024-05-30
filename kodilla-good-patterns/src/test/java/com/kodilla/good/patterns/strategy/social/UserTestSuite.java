package com.kodilla.good.patterns.strategy.social;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    @DisplayName("Testing default")
    void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("William");
        User yGeneration = new YGeneration("Stacy");
        User zGeneration = new ZGeneration("Johanna");

        // When
        String millenialShare = millenial.sharePost();
        String yGenShare = yGeneration.sharePost();
        String zGenShare = zGeneration.sharePost();

        // Then
        assertEquals("This user uses Facebook", millenialShare);
        assertEquals("This user uses Twitter", yGenShare);
        assertEquals("This user uses Snapchat", zGenShare);
    }

    @Test
    @DisplayName("Testing individual")
    void testIndividualSharingStrategy() {
        // Given
        User millenial = new Millenials("Johanna");

        // When
        String defaultShare = millenial.sharePost();
        millenial.setSocialPublisher(new TwitterPublisher());
        String changedShare = millenial.sharePost();

        // Then
        assertEquals("This user uses Facebook", defaultShare);
        assertEquals("This user uses Twitter", changedShare);
    }
}
