package com.zullid.convertrail.api;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import com.zullid.convertrail.api.setup.Config;

public class ApiClient {

    public static void callApi(Config config, String jsonData) throws Exception {

        // Creo el timer
        Timer timer = new Timer();

        // Creo la tarea a ejecutar
        TimerTask task = new TimerTask() {

            // Obtengo la operación a ejecutar
            String operation = config.getMethod().toUpperCase();

            @Override
            public void run() {
                try {
                    switch (operation) {
                        case "GET":
                            ApiController.GetJsonData(config.getUrl());
                            break;
                        case "POST":
                            ApiController.PostJsonData(config.getUrl(), jsonData);
                            break;
                        case "PUT":
                            ApiController.PutJsonData(config.getUrl(), jsonData);
                            break;
                        case "DELETE":
                            ApiController.DeleteJsonData(config.getUrl());
                            break;
                        default:
                            System.out.println("ERROR: Operación no válida.");
                            break;
                    }
                    if (config.isLog()) {
                        System.out.println("LOG: Fin de la llamada a la API");
                        System.out.println("LOG: Esperando " + config.getTimer() + " segundos para la próxima llamada.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // Si Log=true, muestro el estado del programa por consola
        if (config.isLog()) {
            System.out.println("LOG: Ejecutando la tarea cada " + config.getTimer() + " segundos.");
        }
        // Ejecuto la tarea cada X segundos
        timer.schedule(task, 0, config.getTimer() * 1000);

        // Si Result=false, elimino el archivo luego de ejecutar el timer.
        if (!config.isResult()){
			System.out.println("**** Eliminando archivo de resultado");
			File file = new File("json_output\\output.json");
			file.delete();
			System.out.println("**** Archivo eliminado");
		}
    }

    public static void validateData(Config config) throws Exception {

        System.out.println("**** Validando configuración...");
        // Validaciones
        if (config.getUrl() == null || config.getUrl().isEmpty()) {
            throw new Exception("ERROR: No se ha configurado la URL de la API");
        } else if (config.getMethod() == null || config.getMethod().isEmpty()) {
            throw new Exception("ERROR: No se ha configurado el método de la API");
        } else if (config.getTimer() < 0) {
            throw new Exception("ERROR: No se ha configurado correctamente el timer de la API");
        } else {
            System.out.println("**** Configuración correcta.");
        }

    }
}
