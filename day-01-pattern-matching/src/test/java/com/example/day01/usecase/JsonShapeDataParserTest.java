package com.example.day01.usecase;

import com.example.day01.model.Circle;
import com.example.day01.model.Rect;
import com.example.day01.model.Triangle;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonShapeDataParserTest {

    @Test
    void parseJsonData() throws IOException {
        String line = """
              [{"kind":"circle","r":3.0},{"kind":"rect","w":4.0,"h":5.0},{"kind":"triangle","a":3.0,"b":4.0,"c":5.0}]
                """;
        var actual= JsonShapeDataParser.parseJsonData(line);

        val exp = List.of(new Circle(3.0), new Rect(4.0, 5.0), new Triangle(3.0, 4.0, 5.0));


        assertEquals(exp, actual);
    }
}