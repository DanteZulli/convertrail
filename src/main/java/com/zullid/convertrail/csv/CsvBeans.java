package com.zullid.convertrail.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class CsvBeans {
    public static void createBeans(File csvFile, String[] headers) {
        Class<?> dynamicClass = CsvDynamic.createClass(headers);
        try {
            List<?> beans = new CsvToBeanBuilder<>(new FileReader(csvFile))
                    .withType(dynamicClass)
                    .withSeparator(';')
                    .build()
                    .parse();

            // Hacer algo con la lista de beans creados dinámicamente
            beans.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
