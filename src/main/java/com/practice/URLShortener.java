package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;

    private final Map<String, String> shortToOriginal = new HashMap<>();
    private final Map<String, String> originalToShort = new HashMap<>();
    private final Random random = new Random();

    /**
     * Generate a random short code.
     */
    private String generateShortCode() {
        StringBuilder sb = new StringBuilder(SHORT_CODE_LENGTH);
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            int index = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Shorten a given URL.
     */
    public String shortenURL(String originalURL) {
        // If URL already shortened, return existing code
        if (originalToShort.containsKey(originalURL)) {
            return originalToShort.get(originalURL);
        }

        // Generate unique short code
        String shortCode;
        do {
            shortCode = generateShortCode();
        } while (shortToOriginal.containsKey(shortCode));

        shortToOriginal.put(shortCode, originalURL);
        originalToShort.put(originalURL, shortCode);

        return shortCode;
    }

    /**
     * Expand a short code back to original URL.
     */
    public String expandURL(String shortCode) {
        return shortToOriginal.getOrDefault(shortCode, null);
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        String longURL = "https://example.com/some/very/long/path?query=123";
        String shortCode = shortener.shortenURL(longURL);
        System.out.println("Original: " + longURL);
        System.out.println("Shortened: " + shortCode);

        String expanded = shortener.expandURL(shortCode);
        System.out.println("Expanded back: " + expanded);
    }
}
