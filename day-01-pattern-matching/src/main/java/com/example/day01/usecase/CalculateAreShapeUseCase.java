package com.example.day01.usecase;

import com.example.day01.model.Circle;
import com.example.day01.model.Rect;
import com.example.day01.model.Shape;
import com.example.day01.model.Triangle;
import com.example.day01.usecase.port.CalculateShapeUseCase;

public class CalculateAreShapeUseCase implements CalculateShapeUseCase {

    /**
     * Calculates the area of a given shape.
     *
     * @param shape the shape for which to calculate the area
     * @return the area of the shape
     */
    @Override
    public double calculate(Shape shape) {
        return switch (shape) {
            case Circle c -> c.area();
            case Rect r -> r.area();
            case Triangle t -> t.area();
            default -> throw new IllegalArgumentException("Unknown shape: " + shape);
        };
    }
}
