package com.zullid.convertrail.csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// CsvDynamic es una clase que contiene métodos para manejar archivos CSV dinámicamente
// (es decir, sin necesidad de conocer la estructura del CSV de antemano, o modificarla, o crear clases)
// El principal punto de esta clase es brindar una interfaz sencilla 
// y estructurada para utilizar y manipular información desde archivos CSV sin luchar tanto.
public class CsvDynamic {

    public static ArrayList<Map<String, Object>> csvToMap(File csvFile) {
        ArrayList<Map<String, Object>> dataMap = new ArrayList<Map<String, Object>>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] headers = reader.readNext();
            String[] rowData;
            while ((rowData = reader.readNext()) != null) {
                Map<String, Object> dataEntry = new HashMap<>();
                for (int i = 0; i <= headers.length - 1; i++) {
                    String header = headers[i];
                    Object value = rowData[i];
                    dataEntry.put(header, value);
                }
                dataMap.add(dataEntry);
            }
            return dataMap;

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return dataMap;
    }


    public static void mapToJson(ArrayList<Map<String, Object>> dataMap, String jsonFilePath, String jsonFileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(jsonFilePath + "//" + jsonFileName), dataMap);
            System.out.println("The array of maps has been written to " + jsonFilePath + " successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
