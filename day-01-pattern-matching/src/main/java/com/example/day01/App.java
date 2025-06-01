package com.example.day01;

import com.example.day01.Infrastructure.ReaderFromConsole;
import com.example.day01.adapter.Processor;
import com.example.day01.port.DataReader;
import com.example.day01.usecase.CalculateAreShapeUseCase;
import com.example.day01.usecase.PrepareAreaDataUseCase;
import com.example.day01.usecase.SysOutPrintDataUseCase;
import com.example.day01.usecase.port.CalculateShapeUseCase;
import com.example.day01.usecase.port.PrepareDataUseCase;
import com.example.day01.usecase.port.PrintDataUseCase;

/**
 * Demonstration of String Formatting in Java
 * (with comments about String Templates in Java 24)
 */
public class App {
    public static void main(String[] args) {

        CalculateShapeUseCase calculateShapeUseCase = new CalculateAreShapeUseCase();
        PrintDataUseCase printDataUseCase = new SysOutPrintDataUseCase();
        PrepareDataUseCase prepareDataUseCase = new PrepareAreaDataUseCase();
        DataReader dataReader = new ReaderFromConsole();

        Processor processor = new Processor(calculateShapeUseCase, printDataUseCase, prepareDataUseCase, dataReader);
        processor.execute();


    }
}
