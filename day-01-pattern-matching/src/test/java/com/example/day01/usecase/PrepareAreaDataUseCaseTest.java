package com.example.day01.usecase;

import com.example.day01.model.Circle;
import com.example.day01.model.Rect;
import com.example.day01.model.Shape;
import com.example.day01.model.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrepareAreaDataUseCaseTest {

    private PrepareAreaDataUseCase prepareAreaDataUseCase;
    private Function<Shape, Double> mockCalculationFunction;

    @BeforeEach
    void setUp() {
        prepareAreaDataUseCase = new PrepareAreaDataUseCase();
        // Mock calculation function that returns predefined values for testing
        mockCalculationFunction = shape -> {
            if (shape instanceof Circle) {
                return 28.27; // PI * 3^2 rounded to 2 decimal places
            } else if (shape instanceof Rect) {
                return 20.00; // 4 * 5
            } else if (shape instanceof Triangle) {
                return 6.00; // Area of triangle with sides 3, 4, 5
            }
            return 0.0;
        };
    }

    @Test
    void prepareDataShouldFormatResultCorrectly() {
        // Given
        String jsonData = """
              [{"kind":"circle","radius":3.0},{"kind":"rect","w":4.0,"h":5.0},{"kind":"triangle","a":3.0,"b":4.0,"c":5.0}]
                """;
        
        // When
        String result = prepareAreaDataUseCase.prepareData(jsonData, mockCalculationFunction);
        
        // Then
        String expected = """
                Shapes loaded : 3
                • Circle(r=3.0) => 28.27
                • Rect{w=4.00, h=5.00} => 20.00
                • Triangle{a=3.00, b=4.00, c=5.00} => 6.00
                Total area : 54.27
                """;
        assertEquals(expected, result, "Formatted result should match expected output");
    }

    @Test
    void prepareDataShouldThrowExceptionForBlankData() {
        // Given
        String blankData = "";
        
        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            prepareAreaDataUseCase.prepareData(blankData, mockCalculationFunction);
        }, "Should throw IllegalArgumentException for blank data");
        
        assertEquals("Data cannot be blank", exception.getMessage(), 
                "Exception message should be 'Data cannot be blank'");
    }

    @Test
    void prepareDataShouldThrowExceptionForInvalidData() {
        // Given
        String invalidData = "This is not valid JSON";
        
        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            prepareAreaDataUseCase.prepareData(invalidData, mockCalculationFunction);
        }, "Should throw IllegalArgumentException for invalid data");
        
        assertEquals("Invalid data format", exception.getMessage(), 
                "Exception message should be 'Invalid data format'");
    }

    @Test
    void prepareDataShouldThrowExceptionForEmptyShapesList() {
        // Given
        String emptyListData = "[]";
        
        // When & Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            prepareAreaDataUseCase.prepareData(emptyListData, mockCalculationFunction);
        }, "Should throw IllegalArgumentException for empty shapes list");
        
        assertEquals("No shapes found in data", exception.getMessage(), 
                "Exception message should be 'No shapes found in data'");
    }
}