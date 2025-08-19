package com.practice;

import java.util.HashMap;

public class CurrencyConverter2 {

    static HashMap<String, RateLimit> cacheMap = new HashMap<>();

    private static class RateLimit {

        double value;
        long time;

        RateLimit(double value, long time) {
            this.value = value;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        double result1 = convert("USD", "INR", 100);
        System.out.println("100 USD = " + result1 + " INR");
    }


    private static double fetchRateFromAPI(String currency) {
        System.out.println("Fetching rate for " + currency + " from API...");

        switch (currency) {
            case "USD":
                return 1.0;
            case "EUR":
                return 0.91;
            case "GBP":
                return 0.78;
            case "INR":
                return 83.0;
            case "JPY":
                return 145.0;
            default:
                throw new IllegalArgumentException("Unsupported currency code: " + currency);
        }
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = getRate(fromCurrency);
        double toRate = getRate(toCurrency);
        return (amount / fromRate) * toRate;
    }

    static double getRate(String currency) {
        long now = System.currentTimeMillis();
        RateLimit rateLimit = cacheMap.get(currency);
        if(rateLimit != null) {
            if (now - rateLimit.time > 5) {
                return fetchRateFromAPI(currency);
            } else {
                return rateLimit.value;
            }
        }else {
            double val = fetchRateFromAPI(currency);
            cacheMap.put(currency, new RateLimit(val, now));
            return val;
        }
    }
}
