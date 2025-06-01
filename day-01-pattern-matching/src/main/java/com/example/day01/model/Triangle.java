package com.example.day01.model;

public record Triangle(double a, double b, double c) implements Shape {

    @Override
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s- b) * (s - c));
    }
    @Override
    public String toString() {
        return String.format("Triangle{a=%.2f, b=%.2f, c=%.2f}", a, b, c);
    }
}
