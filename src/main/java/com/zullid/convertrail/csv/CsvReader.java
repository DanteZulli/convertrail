package com.zullid.convertrail.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

// La clase CsvReader se encarga de leer y manipular algunas propiedades de los archivos CSV.
public class CsvReader {

    // Método para obtener los headers de un archivo CSV.
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

    // Método para obtener un archivo CSV aleatorio de una carpeta dada.
    public static File getRandomFile(File directory){
        File[] files = directory.listFiles();
        Random rand = new Random();
        File csvFile = files[rand.nextInt(files.length)];
        return csvFile;
    }
}