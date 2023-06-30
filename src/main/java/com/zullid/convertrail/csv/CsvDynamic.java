package com.zullid.convertrail.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.constant.DirectMethodHandleDesc.Kind;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class CsvDynamic {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, CsvValidationException {
        File csvFile = CsvReader.getRandomFile();
        generateClass(CsvReader.getHeaders(csvFile));
        generateBean(csvFile);
    }

    public static void generateClass(String[] headers) throws FileNotFoundException, IOException,
            ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException, CsvValidationException {
        String className = "CsvBeans";

        // Generar la definición de la clase
        StringBuilder sb = new StringBuilder();
        sb.append("package com.zullid.convertrail.csv;\n\n");
        sb.append("import com.opencsv.bean.CsvBindByPosition;\n\n");
        sb.append("public class ").append(className).append(" {\n");

        // Generar los headers
        for (String attribute : headers) {
            sb.append("@CsvBindByPosition(position = ").append(Arrays.asList(headers).indexOf(attribute))
                    .append(")\n");
            sb.append("    private String ").append(attribute).append(";\n");
        }

        // Generar los métodos getter y setter para cada attribute
        for (String attribute : headers) {
            String methodName = attribute.substring(0, 1).toUpperCase() + attribute.substring(1);
            sb.append("\n");
            sb.append("    public String get").append(methodName).append("() {\n");
            sb.append("        return ").append(attribute).append(";\n");
            sb.append("    }\n\n");
            sb.append("    public void set").append(methodName).append("(String ").append(attribute).append(") {\n");
            sb.append("        this.").append(attribute).append(" = ").append(attribute).append(";\n");
            sb.append("    }\n");
        }

        // Override ToString
        sb.append("\n");
        sb.append("    @Override\n");
        sb.append("    public String toString() {\n");
        sb.append("        return \"").append(className).append(" [");
        for (String attribute : headers) {
            sb.append(attribute).append("=\" + ").append(attribute).append(" + \", ");
        }
        sb.append("]\";\n");
        sb.append("    }\n");

        // Cerrar la clase
        sb.append("}");
        
        String outputDirectory = "C://Users//zullid//Documents//Java//convertrail//src//main//java//com//zullid//convertrail//csv//";
        String filePath =  outputDirectory + "/" + className + ".java";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(sb.toString());
        }

        System.out.println("Java file generated successfully: " + filePath);
    }

    public static void generateBean(File csvFile) throws IllegalStateException, IOException {
        List<CsvBeans> beansAdicionales = new CsvToBeanBuilder<CsvBeans>(new FileReader(csvFile))
                .withSkipLines(0)
                .withType(CsvBeans.class)
                .withSeparator(',')
                .build()
                .parse();

        //beansAdicionales.forEach(System.out::println);
        Gson gson = new Gson();
        String path = "C://Users//zullid//Documents//pruebas_convertrail";
        String json = gson.toJson(beansAdicionales);
        try (FileWriter writer = new FileWriter(path + "//beansAdicionales.json")) {
            writer.write(json);
        }
        System.out.println(json);

    }

}
