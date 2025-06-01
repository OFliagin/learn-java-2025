package com.example.day01.usecase;

import com.example.day01.model.Shape;
import com.example.day01.usecase.port.PrepareDataUseCase;

import java.util.List;
import java.util.function.Function;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class PrepareAreaDataUseCase implements PrepareDataUseCase {

    @Override
    public String prepareData(String data, Function<Shape, Double> transformationFunction) {
        final List<Shape> shapes = parseJsonData(data);

        return formatResult(shapes, transformationFunction);

    }

    private List<Shape> parseJsonData(String data) {
        if (isBlank(data)) {
            throw new IllegalArgumentException("Data cannot be blank");
        }
        List<Shape> shapes;
        try {
            shapes = JsonShapeDataParser.parseJsonData(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid data format", e);
        }
        if (shapes.isEmpty()) {
            throw new IllegalArgumentException("No shapes found in data");
        }

        return shapes;
    }

/*
* Formats the result of the area calculations for each shape.
* \nShapes loaded : 3\n• Circle(r=3.0) => 28.27\n• Rect(w=4.0,h=5.0) => 20.00\n• Triangle(3.0,4.0,5.0) => 6.00\nTotal area : 54.27\n
* */
    private String formatResult(List<Shape> shapes, Function<Shape, Double> calculatiShapeonFunction) {
        StringBuilder result = new StringBuilder();
        double totalArea = 0.0;

        result.append("Shapes loaded : ").append(shapes.size()).append("\n");

        for (Shape shape : shapes) {
            double area = calculatiShapeonFunction.apply(shape);
            totalArea += area;
            result.append("• ").append(shape).append(" => ").append(String.format("%.2f", area)).append("\n");
        }

        result.append("Total area : ").append(String.format("%.2f", totalArea)).append("\n");

        return result.toString();
    }




}
