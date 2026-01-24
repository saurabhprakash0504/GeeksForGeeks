package com.companyInterview.wise;

import java.util.*;

public class CurrencyConverterImpl {


    public static void main(String[] args) {
        CurrencyConverterImpl converter = new CurrencyConverterImpl();
        converter.addRate("USD", "EUR", 0.85);
        converter.addRate("EUR", "GBP", 0.9);
        converter.addRate("USD", "JPY", 110.0);

        double amountInGBP = converter.convert("USD", "GBP", 100);
        System.out.println("100 USD in GBP: " + amountInGBP);

        double amountInJPY = converter.convert("EUR", "JPY", 50);
        System.out.println("50 EUR in JPY: " + amountInJPY);
    }


    private final Map<String, Map<String, Double>> graph = new HashMap<>();

    // Add a direct exchange rate
    public void addRate(String from, String to, double rate) {
        graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, rate);
        graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1.0 / rate);
    }

    // Convert amount from one currency to another
    public double convert(String from, String to, double amount) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException("Unknown currency");
        }

        if (from.equals(to)) return amount;

        Set<String> visited = new HashSet<>();
        double rate = dfs(from, to, 1.0, visited);

        if (rate == -1.0) {
            throw new IllegalArgumentException("No conversion path found");
        }

        return amount * rate;
    }

    // DFS to find conversion path
    private double dfs(String current, String target, double accumulatedRate, Set<String> visited) {
        if (current.equals(target)) return accumulatedRate;

        visited.add(current);

        for (Map.Entry<String, Double> entry : graph.get(current).entrySet()) {
            String next = entry.getKey();
            double rate = entry.getValue();

            if (!visited.contains(next)) {
                double result = dfs(next, target, accumulatedRate * rate, visited);
                if (result != -1.0) return result;
            }
        }

        return -1.0; // no path found
    }
}


