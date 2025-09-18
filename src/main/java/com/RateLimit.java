package com;

import java.util.Objects;
import java.util.TreeMap;

public class RateLimit {

   volatile TreeMap<Key, Double> map = new TreeMap<>((a, b) -> {;
       // int nameComp = a.name.compareTo(b.name);

            return a.timestamp.compareTo(b.timestamp);

    });

    public static void main(String[] args) {
        RateLimit rateLimit = new RateLimit();
        rateLimit.putRate("EURUSD", 100100L, 1.01);
        rateLimit.putRate("EURUSD", 100200L, 1.02);
        rateLimit.putRate("EURUSD", 100500L, 1.03);
        rateLimit.putRate("EURUSD", 100699L, 0.95);
        rateLimit.putRate("EURUSD", 100350L, 1.07);

        System.out.println(rateLimit.getRate("EURUSD", 100100L)); // Output: 1.0
        System.out.println(rateLimit.getRate("EURUSD", 100399L)); // Output: 1.5
        System.out.println(rateLimit.getRate("EURUSD", 100599L)); // Output: 0.9
        System.out.println(rateLimit.getRate("EURUSD", 100001L)); // Output: -1.0 (not found)
        System.out.println(rateLimit.getRate("USDJPY", 100001L)); // Output: -1.0 (not found)


    }


    synchronized void putRate(String name, Long timestamp, Double rate) {
        Key key = new Key(name, timestamp);
        map.put(key, rate);
    }



    double getRate(String name, Long timestamp) {
        Key key = new Key(name, timestamp);
        double value = -1.0;
        if (map.containsKey(key)) {
            value = map.get(key);
        } else {
            Key floorKey = map.floorKey(key);
            if (floorKey != null && floorKey.name.equals(name)) {
                value = map.get(floorKey);
            }
        }
        //  return map.getOrDefault(key, -1.0);

        if (value == -1.0) {
            throw new IllegalStateException();
        }
        return value;
    }


    class Key {
        String name;
        Long timestamp;
        Key(String name, Long timestamp) {
            this.name = name;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(name, key.name) && Objects.equals(timestamp, key.timestamp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, timestamp);
        }
    }


}
