package com.example.day01.adapter;

import com.example.day01.port.DataReader;
import com.example.day01.usecase.port.CalculateShapeUseCase;
import com.example.day01.usecase.port.PrepareDataUseCase;
import com.example.day01.usecase.port.PrintDataUseCase;

public class Processor {

    private final CalculateShapeUseCase calculateShapeUseCase;
    private final PrintDataUseCase printDataUseCase;
    private final PrepareDataUseCase prepareDataUseCase;
    private final DataReader dataReader;

    // Manually added constructor since Lombok's @RequiredArgsConstructor is not working
    public Processor(CalculateShapeUseCase calculateShapeUseCase, 
                    PrintDataUseCase printDataUseCase, 
                    PrepareDataUseCase prepareDataUseCase, 
                    DataReader dataReader) {
        this.calculateShapeUseCase = calculateShapeUseCase;
        this.printDataUseCase = printDataUseCase;
        this.prepareDataUseCase = prepareDataUseCase;
        this.dataReader = dataReader;
    }


    public void execute() {
        // Read data from the data source
        String data = dataReader.readData();
        // Prepare the data
        String preparedData = prepareDataUseCase.prepareData(data, calculateShapeUseCase::calculate);
        // Print the prepared data
        printDataUseCase.printData(preparedData);


    }
}
