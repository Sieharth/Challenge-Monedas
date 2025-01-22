package com.alura.Conversor;
import java.util.Map;

public class RatiosIntercambio {
    private String base_code; // Moneda base
    private Map<String, Double> conversion_rates; // Tasas de cambio

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}