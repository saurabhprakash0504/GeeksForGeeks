package com.greedy;

import java.math.BigInteger;

public class LargestNumber {


    public static void main(String[] args) {
        System.out.println(largestNumber(50, 363));
    }

    static String largestNumber(int n, int sum) {
        // add your code here
        int rem = sum;
        BigInteger num = BigInteger.ZERO;
        int count = 0;
        while (rem != 0) {
            if (rem >= 9) {
                num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(9)) ;
                rem = rem - 9;

            } else {
                num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(rem)) ;
                rem = 0;
            }
         //   System.out.println("num >> "+ num);
            count++;
        }
        // System.out.println("count << "+ count);

        if (count > n) {
            return Integer.toString(-1);
        }
        String s = "";
        if (num == BigInteger.ZERO) {
            while (count < n) {
                s = s + "0";
                count++;
            }
            return s;
        }

        while (count < n) {
            num = num.multiply(BigInteger.TEN);
            count++;
        }

      /*  if(num != count){
            return Integer.toString(-1);
        }*/

      //  return Integer.toString(num);
        return String.valueOf(num);
    }
}
