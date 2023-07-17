package com.zullid.convertrail.conversion;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVFileConverter implements FileConverter<ArrayList<Map<String, Object>>, File> {
    
    @Override
    public ArrayList<Map<String, Object>> convert(File file) {
        ArrayList<Map<String, Object>> dataMap = new ArrayList<Map<String, Object>>();
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
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
}
