package com.zullid.convertrail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.exceptions.CsvValidationException;
import com.zullid.convertrail.csv.CsvDynamic;
import com.zullid.convertrail.csv.CsvReader;
@SpringBootApplication
public class ConvertrailApplication {

	public static void main(String[] args) throws CsvValidationException, FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		SpringApplication.run(ConvertrailApplication.class, args);
	}
}
