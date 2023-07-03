package com.zullid.convertrail.api.setup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToBean {

    public static Config getConfig() throws IOException {
        System.out.println("**** Leyendo archivo de configuración...");
        System.out.println("NOTA: Recuerda que debes definir el archivo de configuración correctamente en el archivo Config.json");
        String filePath = "src/main/java/com/zullid/convertrail/api/setup/Config.json";
        return jsonToBean(filePath);
    }
    public static String readFileAsString(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        return new String(bytes);
    }
    public static Config jsonToBean(String filePath) throws IOException {
        String jsonContent = readFileAsString(filePath);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<Config>(){});
    }
}
