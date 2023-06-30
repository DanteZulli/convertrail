package com.zullid.convertrail.csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CsvDynamic {

    public static void main(String[] args) throws FileNotFoundException {

        File csvFile = CsvReader.getRandomFile();
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
            String jsonFilePath = "c://Users//zullid//Documents//json//data.json";
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                objectMapper.writeValue(new File(jsonFilePath), dataMap);
                System.out.println("The array of maps has been written to " + jsonFilePath + " successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

}
