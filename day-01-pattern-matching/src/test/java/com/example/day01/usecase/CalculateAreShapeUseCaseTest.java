package com.example.day01.usecase;

import com.example.day01.model.Circle;
import com.example.day01.model.Rect;
import com.example.day01.model.Shape;
import com.example.day01.model.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateAreShapeUseCaseTest {

    private CalculateAreShapeUseCase calculateAreShapeUseCase;

    @BeforeEach
    void setUp() {
        calculateAreShapeUseCase = new CalculateAreShapeUseCase();
    }

    @Test
    void calculateCircleArea() {
        // Given
        Circle circle = new Circle(3.0);
        
        // When
        double area = calculateAreShapeUseCase.calculate(circle);
        
        // Then
        assertEquals(Math.PI * 3.0 * 3.0, area, 0.001, "Circle area should be calculated correctly");
    }

    @Test
    void calculateRectArea() {
        // Given
        Rect rect = new Rect(4.0, 5.0);
        
        // When
        double area = calculateAreShapeUseCase.calculate(rect);
        
        // Then
        assertEquals(20.0, area, 0.001, "Rectangle area should be calculated correctly");
    }

    @Test
    void calculateTriangleArea() {
        // Given
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        
        // When
        double area = calculateAreShapeUseCase.calculate(triangle);
        
        // Then
        // Using Heron's formula: sqrt(s(s-a)(s-b)(s-c)) where s = (a+b+c)/2
        double s = (3.0 + 4.0 + 5.0) / 2;
        double expectedArea = Math.sqrt(s * (s - 3.0) * (s - 4.0) * (s - 5.0));
        assertEquals(expectedArea, area, 0.001, "Triangle area should be calculated correctly");
    }

    @Test
    void throwExceptionForUnknownShape() {
        // Given
        Shape unknownShape = new Shape() {
            @Override
            public double area() {
                return 0;
            }
        };
        
        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateAreShapeUseCase.calculate(unknownShape);
        }, "Should throw IllegalArgumentException for unknown shape");
        
        assertTrue(exception.getMessage().contains("Unknown shape"), 
                "Exception message should contain 'Unknown shape'");
    }
}