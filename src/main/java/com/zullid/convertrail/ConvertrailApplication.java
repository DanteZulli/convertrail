package com.zullid.convertrail;

import java.io.File;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zullid.convertrail.conversion.CSVToJSONAdapter;
import com.zullid.convertrail.input.CSVInputContext;
import com.zullid.convertrail.input.CSVInputStrategy;
import com.zullid.convertrail.input.FileCSVInputStrategy;

@SpringBootApplication
public class ConvertrailApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConvertrailApplication.class, args);

        // Ruta y nombre del archivo JSON de salida
        String jsonFilePath = "json_output";
        String jsonFileName = "salida.json";

        // Instancio la Strategy correspondiente para leer el CSV
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el método para ingresar el CSV (file): ");
        String inputMethod = scanner.nextLine();
        CSVInputStrategy strategy;
        switch (inputMethod) {
            case "file":
                strategy = new FileCSVInputStrategy();
                break;
            default:
                scanner.close();
                throw new Exception("Método de ingreso de CSV inválido");
        }
        // Le paso la Strategy al context para que me devuelva el archivo
        // correspondiente
        CSVInputContext context = new CSVInputContext(strategy);
        File csvFile = context.getCSV();
        scanner.close();

        // Crear instancia del adaptador a utilizar, llamo al método de conversión
        CSVToJSONAdapter adapter = new CSVToJSONAdapter();
        adapter.convertCSVToJson(csvFile, jsonFilePath, jsonFileName);
    }
}
