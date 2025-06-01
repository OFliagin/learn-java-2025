package com.example.day01.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Circle(@JsonAlias("r") double radius) implements Shape {

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

   public String toString() {
        return "Circle(r=" + radius + ")";
    }
}
