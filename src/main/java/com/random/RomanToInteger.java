package com.random;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {

        RomanToInteger obj = new RomanToInteger();
        String s = "MCMXCIV";
        int result = obj.romanToDecimal(s);
        System.out.println("Roman numeral: " + s + " => Integer: " + result);
    }

    public int romanToDecimal(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int val =0;
        for(int i=0;i<s.length();){
            char c = s.charAt(i);
            int curr = map.get(c);

            if(i+1 < s.length()){
                char c2 = s.charAt(i+1);
                int next = map.get(c2);
                if(curr >= next){
                    val = val + curr;
                    i = i +1;
                }else{
                    val = val + (next - curr);
                    i = i+2;
                }
            }else{
                val = val + curr;
                i= i+1;
            }
        }

        return val;
    }
}
