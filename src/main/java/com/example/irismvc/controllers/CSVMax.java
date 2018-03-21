package com.example.irismvc.controllers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CSVMax {

    public static String makeCapital(String name){
        return name.toUpperCase();
    }



    private static final String SAMPLE_CSV_FILE_PATH = "C:\\stocks\\csv-capstone-db\\data\\iris.csv";

    private static final String SAMPLE_CSV_FILE = "C:\\stocks\\csv-capstone-db\\data\\3-17-2018-results.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());

                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        //                       .withHeader("date", "record number","open close decrease","percentage decrease","word list"));
                        .withHeader("countries"));
        ) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            CSVRecord largestSoFar = null;
            int count = 0;
            for (CSVRecord currentRow : csvRecords) {
                // If largestSoFar is nothing
                String speciesType = currentRow.get("species");
                if (speciesType.equals("versicolor")){
                    count++;
                }
                if (largestSoFar ==null){
                    largestSoFar = currentRow;
                }



                else {

                    double currentSepalLength = Double.parseDouble(currentRow.get("sepal_length"));
                    double largestSepalLength = Double.parseDouble(largestSoFar.get("sepal_length"));
                    double currentSepalWidth = Double.parseDouble(currentRow.get("sepal_width"));
                    double largestSepalWidth = Double.parseDouble(currentRow.get("sepal_width"));
                    double currentPetalLength = Double.parseDouble(currentRow.get("petal_length"));
                    double largestPetalLength = Double.parseDouble(currentRow.get("petal_length"));
                    double currentPetalWidth = Double.parseDouble(currentRow.get("petal_width"));
                    double largestPetalWidth = Double.parseDouble(currentRow.get("petal_width"));




                    if (currentSepalLength > largestSepalLength){
                        largestSoFar = currentRow;

                    }





                }


            }

            System.out.println("largest sepal length is " + largestSoFar.get("sepal_length") +
                    " with species as " + largestSoFar.get("species") + " capitalized is " +makeCapital(largestSoFar.get("species")));

            System.out.println("There are " +count+ " versicolor");
        }

    }

}
