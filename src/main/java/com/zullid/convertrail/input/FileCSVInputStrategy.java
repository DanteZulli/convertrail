package com.zullid.convertrail.input;

import java.io.File;
import java.util.Scanner;

public class FileCSVInputStrategy implements CSVInputStrategy {
    @Override
    public File readCSV() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la ruta del archivo: ");
        String filePath = scanner.nextLine();
        File csvFile = new File(filePath);
        scanner.close();
        return csvFile;
    }
}
