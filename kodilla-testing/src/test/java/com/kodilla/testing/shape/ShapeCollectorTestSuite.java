package com.kodilla.testing.shape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ShapeCollector Test Suite")
class ShapeCollectorTestSuite {

    private ShapeCollector shapeCollector;

    @BeforeEach
    void setUp() {
        shapeCollector = new ShapeCollector();
    }

    @Nested
    @DisplayName("Tests for adding and removing shapes")
    class AddAndRemoveTests {
        @Test
        @DisplayName("Should add shape to collection")
        void testAddFigure() {
            // Given
            Shape shape = new Square(5);

            // When
            shapeCollector.addFigure(shape);

            // Then
            assertEquals(1, shapeCollector.getShapes().size());
            assertTrue(shapeCollector.getShapes().contains(shape));
        }

        @Test
        @DisplayName("Should remove shape from collection")
        void testRemoveFigure() {
            // Given
            Shape shape = new Circle(4);
            shapeCollector.addFigure(shape);

            // When
            shapeCollector.removeFigure(shape);

            // Then
            assertTrue(shapeCollector.getShapes().isEmpty());
        }
    }

    @Nested
    @DisplayName("Tests for getting shapes")
    class GetShapesTests {
        @Test
        @DisplayName("Should get shape from collection by index")
        void testGetFigure() {
            // Given
            Shape square = new Square(5);
            shapeCollector.addFigure(square);

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertEquals(square, retrievedShape);
        }
        @Test
        @DisplayName("Should return null when getting shape with invalid index")
        void testGetFigureInvalidIndex() {
            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertEquals(null, retrievedShape);
        }
    }

    @Nested
    @DisplayName("Tests for showing shapes")
    class ShowShapesTests {
        @Test
        @DisplayName("Should return string with names of all shapes")
        void testShowFigures() {
            // Given
            Shape square = new Square(5);
            Shape circle = new Circle(4);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            String expectedOutput = "Square, Circle";

            // When
            String output = shapeCollector.showFigures();

            // Then
            assertEquals(expectedOutput, output);
        }

        @Test
        @DisplayName("Should return empty string when there are no shapes")
        void testShowFiguresEmpty() {
            // When
            String output = shapeCollector.showFigures();

            // Then
            assertEquals("", output);
        }
    }
}
