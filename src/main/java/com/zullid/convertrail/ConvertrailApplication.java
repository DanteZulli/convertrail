package com.zullid.convertrail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.exceptions.CsvValidationException;
import com.zullid.convertrail.csv.CsvDynamic;
import com.zullid.convertrail.csv.CsvReader;

@SpringBootApplication
public class ConvertrailApplication {

	public static void main(String[] args) throws CsvValidationException, FileNotFoundException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, IOException {
		SpringApplication.run(ConvertrailApplication.class, args);

		// Archivo CSV Aleatorio desde una carpeta (Para probar la capacidad del programa
		// de mappear y convertir cualquier CSV dinámicamente)
		File dir = new File("csv_pruebas");
		File csvFile = CsvReader.getRandomFile(dir);
		// Archivo CSV específico.
		// File csvFile = new File("csv_pruebas\\prueba.csv");
		
		// Un Log humilde
		System.out.println("The selected csv file is: " + csvFile.getName());

		// Mappeado de CSV a ArrayList de Maps
		ArrayList<Map<String, Object>> mappedCsv = CsvDynamic.csvToMap(csvFile);

		// Conversión de ArrayList de Maps a JSON
		CsvDynamic.mapToJson(mappedCsv, "json_output", "output.json");
	}
}
