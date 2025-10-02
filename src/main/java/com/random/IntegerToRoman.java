package com.random;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {

        IntegerToRoman obj = new IntegerToRoman();
        int n = 1994;
        String result = obj.convertToRoman(n);
        System.out.println("Integer: " + n + " => Roman numeral: " + result);

    }

    String convertToRoman(int n) {
        // code here
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            if (n / key > 0) {
                int val = n / key;
                while (val > 0) {
                    sb.append(entry.getValue());
                    val = val - 1;
                }
                n = n % key;
            }
        }
        return sb.toString();
    }
}
