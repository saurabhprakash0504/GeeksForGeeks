package com.companyInterview.wise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RateLimiter {

    private Map<String, Integer> messageTimestamps;

    private final ConcurrentMap<String, Integer> lastPrinted;

    RateLimiter() {
        messageTimestamps = new HashMap<>();
        lastPrinted = new ConcurrentHashMap<>();
    }


    public static void main(String[] args) {

        RateLimiter rateLimiter = new RateLimiter();
        System.out.println(rateLimiter.firstEasyImplementation(1, "foo")); // true
        System.out.println(rateLimiter.firstEasyImplementation(2, "bar")); // true
        System.out.println(rateLimiter.firstEasyImplementation(3, "foo")); // false
        System.out.println(rateLimiter.firstEasyImplementation(8, "bar")); // false
        System.out.println(rateLimiter.firstEasyImplementation(10, "foo")); // false
        System.out.println(rateLimiter.firstEasyImplementation(11, "foo")); // true
    }


    public boolean firstEasyImplementation(int timestamp, String message) {
        // If message is new or enough time has passed since last print
        if (!messageTimestamps.containsKey(message) ||
                timestamp - messageTimestamps.get(message) >= 10) {

            messageTimestamps.put(message, timestamp);
            return true;
        }

        return false;
    }


    //Thread Safe version
    //We will use concurrent hashMap to store the last printed timestamps for each message.
    public synchronized boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTime = lastPrinted.get(message);
        if (lastTime == null || timestamp - lastTime >= 10) {
            lastPrinted.put(message, timestamp);
            return true;
        }
        return false;
    }


    // Memory efficient version
    // We will periodically clean up old messages that are no longer needed.
    //In Deque we will maintain the order of messages based on their timestamps.
    private Deque<String> order = new ArrayDeque<>();

    public boolean thirdImplementationWithMemoryEfficiency(int timestamp, String message) {

        // Cleanup old messages
        while (!order.isEmpty()) {
            String oldest = order.peekFirst();
            int lastTime = messageTimestamps.get(oldest);

            // If this message is older than 10 seconds, remove it
            if (timestamp - lastTime >= 10) {
                order.pollFirst();
                messageTimestamps.remove(oldest);
            } else {
                break; // remaining messages are newer
            }
        }

        // Now apply the normal rate-limiter logic
        if (!messageTimestamps.containsKey(message) ||
                timestamp - messageTimestamps.get(message) >= 10) {

            messageTimestamps.put(message, timestamp);
            order.offerLast(message);
            return true;
        }

        return false;
    }


}

