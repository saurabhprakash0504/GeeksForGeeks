package com.practice;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private static final long CACHE_EXPIRY_MS = 60 * 60 * 1000; // 1 hour
    private static final Map<String, RateCache> rateCacheMap = new HashMap<>();

    // Inner class to store rate and its last updated time
    private static class RateCache {
        double rateToUSD;
        long lastUpdated;

        RateCache(double rateToUSD, long lastUpdated) {
            this.rateToUSD = rateToUSD;
            this.lastUpdated = lastUpdated;
        }
    }

    /**
     * Dummy API fetch (replace with real API call).
     * Fetches 1 unit of the currency in terms of USD.
     */
    private static double fetchRateFromAPI(String currency) {
        System.out.println("Fetching rate for " + currency + " from API...");

        switch (currency) {
            case "USD": return 1.0;
            case "EUR": return 0.91;
            case "GBP": return 0.78;
            case "INR": return 83.0;
            case "JPY": return 145.0;
            default: throw new IllegalArgumentException("Unsupported currency code: " + currency);
        }
    }

    /**
     * Get rate for a specific currency (cached per currency).
     */
    private static double getRate(String currency) {
        long now = System.currentTimeMillis();

        RateCache cache = rateCacheMap.get(currency);

        if (cache == null || (now - cache.lastUpdated) > CACHE_EXPIRY_MS) {
            // Cache miss or expired
            double freshRate = fetchRateFromAPI(currency);
            rateCacheMap.put(currency, new RateCache(freshRate, now));
            return freshRate;
        }

        return cache.rateToUSD;
    }

    /**
     * Convert amount between currencies using USD as pivot.
     */
    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = getRate(fromCurrency);
        double toRate = getRate(toCurrency);

        // Convert from source -> USD -> target
        double amountInUSD = amount / fromRate;
        return amountInUSD * toRate;
    }

    public static void main(String[] args) {
        double result1 = convert("USD", "INR", 100);
        System.out.println("100 USD = " + result1 + " INR");

        double result2 = convert("EUR", "GBP", 50);
        System.out.println("50 EUR = " + result2 + " GBP");

        // This will NOT hit API for USD/INR again if within 1 hour
        double result3 = convert("USD", "INR", 200);
        System.out.println("200 USD = " + result3 + " INR");

        // If you try JPY, it fetches JPY only
        double result4 = convert("JPY", "GBP", 1000);
        System.out.println("1000 JPY = " + result4 + " GBP");
    }
}