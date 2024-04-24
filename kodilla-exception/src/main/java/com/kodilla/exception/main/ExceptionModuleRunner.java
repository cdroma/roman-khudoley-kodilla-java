package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionModuleRunner {

    public static void main(String[] args) throws FileReaderException {
        FileReader fileReader = new FileReader();

        fileReader.readFile();
    }
}
