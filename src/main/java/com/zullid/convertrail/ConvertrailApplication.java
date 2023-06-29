package com.zullid.convertrail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.exceptions.CsvValidationException;
import com.zullid.convertrail.csv.CsvReader;
import com.zullid.convertrail.csv.CsvBeans;
import com.zullid.convertrail.csv.CsvDynamic;

@SpringBootApplication
public class ConvertrailApplication {

	public static void main(String[] args) throws CsvValidationException, FileNotFoundException, IOException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		SpringApplication.run(ConvertrailApplication.class, args);
		File csvFile = CsvReader.getRandomFile();
		String[] headers = CsvReader.getHeaders(csvFile);
	    CsvBeans.createBeans(csvFile, headers);
	}
}
