package com.example.day01.Infrastructure;

import com.example.day01.port.DataReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReaderFromConsole implements DataReader {
    /**
     * This method reads string data in JSON format from the standard input (System.in).
     * It reads all bytes from the input stream and converts them to a String.
     *
     * @return A String containing the JSON data read from the console.
     */

    @Override
    public String readData() {
        try {
            // Use BufferedReader instead of System.console() as it works in all environments
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter JSON data:");
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Error reading from console", e);
        }
    }
}
