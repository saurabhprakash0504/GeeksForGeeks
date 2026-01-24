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


    private Map<String, Map<String, Double>> graph = new HashMap<>();

    // Add a direct exchange rate
    public void addRate(String from, String to, double rate) {

        // Add "from" → "to"
        if (!graph.containsKey(from)) {
            graph.put(from, new HashMap<String, Double>());
        }
        graph.get(from).put(to, rate);

        // Add reverse "to" → "from"
        if (!graph.containsKey(to)) {
            graph.put(to, new HashMap<String, Double>());
        }
        graph.get(to).put(from, 1.0 / rate);
    }

    public double convert(String from, String to, double amount) {

        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException("Unknown currency");
        }

        if (from.equals(to)) {
            return amount;
        }

        Set<String> visited = new HashSet<String>();
        Result result = new Result();

       // double rate = dfs(from, to, 1.0, visited);

        /*if (rate == -1.0) {
            throw new IllegalArgumentException("No conversion path found");
        }

        return amount * rate;*/

        boolean found = dfs(from, to, 1.0, visited, result);

        if (!found) {
            throw new IllegalArgumentException("No conversion path found");
        }

        return amount * result.rate;
    }

    private double dfs(String current, String target, double accumulatedRate, Set<String> visited) {

        if (current.equals(target)) {
            return accumulatedRate;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);

        for (String next : neighbors.keySet()) {
            if (!visited.contains(next)) {
                double nextRate = neighbors.get(next);
                double result = dfs(next, target, accumulatedRate * nextRate, visited);

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0; // no path found
    }

    private boolean dfs(String current,
                        String target,
                        double accumulatedRate,
                        Set<String> visited,
                        Result result) {

        if (current.equals(target)) {
            result.rate = accumulatedRate;
            return true;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);

        for (String next : neighbors.keySet()) {
            if (!visited.contains(next)) {

                double nextRate = accumulatedRate * neighbors.get(next);

                // If path found, bubble up success
                if (dfs(next, target, nextRate, visited, result)) {
                    return true;
                }
            }
        }

        // Backtrack
        visited.remove(current);
        return false;
    }

}

class Result {
    double rate;
}
