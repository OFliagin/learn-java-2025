package com.example.day01.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Rect (@JsonAlias("w") double width, @JsonAlias("h") double height) implements Shape {

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("Rect{w=%.2f, h=%.2f}", width, height);
    }
}
