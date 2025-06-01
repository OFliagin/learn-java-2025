package com.example.day01.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This interface represents a geometric shape.
 * It provides a method to calculate the area of the shape.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "kind")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rect.class, name = "rect"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle")
})
public interface Shape {
    double area();
}
