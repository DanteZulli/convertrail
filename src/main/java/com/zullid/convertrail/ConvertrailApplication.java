package com.zullid.convertrail;

import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zullid.convertrail.conversion.CSVToJSONAdapter;

@SpringBootApplication
public class ConvertrailApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConvertrailApplication.class, args);

		// Ruta y nombre del archivo CSV
        File csvFile = new File("csv_pruebas\\cities.csv");
        
        // Ruta y nombre del archivo JSON de salida
        String jsonFilePath = "json_output";
        String jsonFileName = "salida.json";
        
        // Crear instancia del adaptador
        CSVToJSONAdapter adapter = new CSVToJSONAdapter();
        
        // Llamar al método convertCSVToJson
        adapter.convertCSVToJson(csvFile, jsonFilePath, jsonFileName);
	}
}
