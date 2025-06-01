package com.example.day01.usecase;

import com.example.day01.usecase.port.PrintDataUseCase;

public class SysOutPrintDataUseCase implements PrintDataUseCase {

    @Override
    public void printData(String data) {
        System.out.println(data);
    }
}