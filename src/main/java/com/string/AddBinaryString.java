package com.string;

import java.math.BigInteger;
import java.util.HashMap;

public class AddBinaryString {

    public static void main(String[] args) {
        AddBinaryString addBinaryString = new AddBinaryString();
        // String s = addBinaryString.addBinary("100100000111111101010010010011010101110110", "1011101001111110010000000001010001101100000010010110001111100010101100011110001011101000100011111111111010000010010101010111001000010100101100001101011101101011011001000110111111010000000110110000010101100100010000111000100111100110001110111101010011001011010011011010011110111101111001001001010111110001101000100011101001011000110100");
        String s = addBinaryString.addBinary("01001001", "0110101");
        System.out.println("firstWay >> " + s);

        System.out.println("secondWay >>  " + addBinaryString.addBinaryVal("01001001", "0110101"));
    }

    public String addBinary(String s1, String s2) {
        // code here
        BigInteger num1 = findIntFromBinary(s1);
        // System.out.println("num "+num1);
        BigInteger num2 = findIntFromBinary(s2);
        // System.out.println("num2  "+num2);
        BigInteger sum = num1.add(num2);
        // String s = "";
        String s = findBinary(sum);
        // System.out.println("s  "+s);
        return s;
    }

    BigInteger findIntFromBinary(String s) {
        BigInteger num = BigInteger.valueOf(0);
        BigInteger i = BigInteger.ONE;
        for (int ii = s.length() - 1; ii >= 0; ii--) {
            char c = s.charAt(ii);
            int j = (int) c - '0';
            num = num.add(BigInteger.valueOf(j).multiply(i));
            i = i.multiply(BigInteger.TWO);
        }

        return num;
    }

    String findBinary(BigInteger num) {
        String s = "";
//        while(num.compareTo(BigInteger.ONE) == 1 || num.compareTo(BigInteger.ONE) == 0 ){
        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger rem = num.mod(BigInteger.valueOf(2));
            s = rem + s;
            num = num.divide(BigInteger.TWO);
        }
        return s;
    }


    public String addBinaryVal(String s1, String s2) {
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int temp = 0;
        int c1 = 0;
        int c2 = 0;
        StringBuffer sb = new StringBuffer();
        while (len1 >= 0 || len2 >= 0) {
            if (len1 >= 0)
                c1 = s1.charAt(len1) - '0';
            else
                c1 = 0;
            if (len2 >= 0)
                c2 = s2.charAt(len2) - '0';
            else
                c2 = 0;
            int sum = c1 + c2 + temp;

            sb.append(sum % 2);
            temp = sum / 2;
            len1--;
            len2--;
        }
        sb.append(temp);
        sb = sb.reverse();
        int len = sb.length();
        int i=0;
        while (i<len){
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
            i++;
        }
        return sb.toString();
    }
}
