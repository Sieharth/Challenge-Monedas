package com.alura.Conversor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cliente {
    private static final String API_KEY = "aeee7311b0ee7c76f7fe8d8f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static String getRatiosIntercambio(String baseCurrency) {
        StringBuilder response = new StringBuilder();
        try {
            // Construir la URL completa
            String apiUrl = BASE_URL + baseCurrency;
            URL url = new URL(apiUrl);

            // Establecer la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);

            }
            reader.close();

        }catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
        }
        return response.toString();
    }
}