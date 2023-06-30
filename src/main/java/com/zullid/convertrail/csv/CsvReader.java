package com.zullid.convertrail.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {

    public static String[] getHeaders(File csvFile) throws FileNotFoundException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] headers = reader.readNext();
            reader.close();
            return headers;
        } catch (FileNotFoundException e) {
            throw e;
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File getRandomFile(File directory){
        File[] files = directory.listFiles();
        Random rand = new Random();
        File csvFile = files[rand.nextInt(files.length)];
        System.out.println("The csv file is: " + csvFile.getName());
        return csvFile;
    }
}