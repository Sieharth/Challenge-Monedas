package com.alura.Conversor;

import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Moneda base para la consulta (puedes cambiarla según tu preferencia)
        String baseCurrency = "USD";

        // Conectar a la API y obtener el JSON
        String json = Cliente.getRatiosIntercambio(baseCurrency);

        // Parsear el JSON con Gson
        Gson gson = new Gson();
        RatiosIntercambio rates = gson.fromJson(json, RatiosIntercambio.class);

        // Mostrar las tasas de cambio para algunas monedas
        System.out.println("Tasas de cambio para " + rates.getBaseCode() + ":");
        Map<String, Double> conversionRates = rates.getConversionRates();
        for (String currency : new String[]{"EUR", "JPY", "GBP"}) {
            System.out.printf("%s: %.2f%n", currency, conversionRates.get(currency));
        }
        // Permitir conversión interactiva
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad en " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        System.out.println("Conversión:");
        for (String currency : new String[]{"EUR", "JPY", "GBP"}) {
            double rate = conversionRates.get(currency);
            System.out.printf("%s: %.2f%n", currency, amount * rate);
        }
    }
}


