package com.example.day01.usecase.port;

import com.example.day01.model.Shape;

import java.util.function.Function;

public interface PrepareDataUseCase {
    String prepareData(String data, Function<Shape, Double> transformationFunction);
}
