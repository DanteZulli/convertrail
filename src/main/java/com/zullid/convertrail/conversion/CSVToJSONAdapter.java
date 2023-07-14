package com.zullid.convertrail.conversion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CSVToJSONAdapter {
    private CSVFileConverter csvConverter;
    private JSONFileConverter jsonConverter;

    public CSVToJSONAdapter() {
        this.csvConverter = new CSVFileConverter();
        this.jsonConverter = new JSONFileConverter();
    }

    public void convertCSVToJson(File csvFile, String jsonFilePath, String jsonFileName) {
        ArrayList<Map<String, Object>> dataMap = csvConverter.convert(csvFile);
        String jsonData = jsonConverter.convert(dataMap);
        if (jsonData != null) {
            try (FileWriter writer = new FileWriter(jsonFilePath + "//" + jsonFileName)) {
                writer.write(jsonData);
                System.out.println("**** El arreglo de maps fue guardado en " + jsonFilePath + " satisfactoriamente!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
