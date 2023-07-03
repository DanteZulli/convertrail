package com.zullid.convertrail;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zullid.convertrail.api.ApiClient;
import com.zullid.convertrail.api.setup.Config;
import com.zullid.convertrail.api.setup.JsonToBean;
import com.zullid.convertrail.csv.CsvDynamic;
import com.zullid.convertrail.csv.CsvReader;

@SpringBootApplication
public class ConvertrailApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConvertrailApplication.class, args);

		// Archivo CSV Aleatorio desde una carpeta (Para probar la capacidad del programa
		// de mappear y convertir cualquier CSV dinámicamente)
		File dir = new File("csv_pruebas");
		File csvFile = CsvReader.getRandomFile(dir);
		// Archivo CSV específico.
		// File csvFile = new File("csv_pruebas\\prueba.csv");
		
		// Un Log humilde
		System.out.println("**** El archivo CSV seleccionado es: " + csvFile.getName());

		// Mappeado de CSV a ArrayList de Maps
		ArrayList<Map<String, Object>> mappedCsv = CsvDynamic.csvToMap(csvFile);

		// Conversión de ArrayList de Maps a JSON
		CsvDynamic.mapToJson(mappedCsv, "json_output", "output.json");

		// Request a la API de Convertrail
		// Primero setteamos la configuración de la API
		Config config = JsonToBean.getConfig();
		// Validamos para que nada explote
		ApiClient.validateData(config);
		// Llamamos a la API
		ApiClient.callApi(config, "json_output\\output.json");

	}
}
