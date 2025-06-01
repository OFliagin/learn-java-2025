package com.example.day01.usecase;

import com.example.day01.model.Circle;
import com.example.day01.model.Rect;
import com.example.day01.model.Shape;
import com.example.day01.model.Triangle;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class JsonShapeDataParser {
    private JsonShapeDataParser() {
    }

    /**
     * This method reads JSON data from the input string and parses it into a list of EntryData objects.
     * It uses Jackson's JsonParser to read the JSON data.
     *
     * @param jsonData The JSON data as a string.
     * @return A list of EntryData objects parsed from the JSON data.
     * @throws IOException If there is an error parsing the JSON data.
     */
    public static List<Shape> parseJsonData(String jsonData) throws IOException {
        JsonParser parser = getParser(jsonData);
        List<Shape> entryDataList = new ArrayList<>();
        try {
            final Iterator<Shape[]> iterator = parser.readValuesAs(Shape[].class);
            while (iterator.hasNext()) {
                Shape[] shapes = iterator.next();
                Collections.addAll(entryDataList, shapes);
            }
            return entryDataList;
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON data", e);
        }

    }


    /**
     * This method creates a JSON parser using Jackson.
     * It is used to parse the JSON data from the input string.
     *
     * @param json The JSON string to be parsed.
     * @return A JsonParser instance for parsing the JSON data.
     */
    private static JsonParser getParser(String json) {
        try {
            JsonMapper mapper = new JsonMapper();
            // Configure polymorphic deserialization
            mapper.registerSubtypes(Circle.class, Rect.class, Triangle.class);
            mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            mapper.configOverride(Shape.class);
            return mapper.getFactory().createParser(json);
        } catch (IOException e) {
            throw new RuntimeException("Error creating JSON parser", e);
        }
    }


}
