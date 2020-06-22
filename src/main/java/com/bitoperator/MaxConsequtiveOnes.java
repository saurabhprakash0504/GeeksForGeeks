package com.bitoperator;

public class MaxConsequtiveOnes {
	public static void main(String[] args) {
		System.out.println(maxConsecutiveOnes(46));
	}

	public static int maxConsecutiveOnes(int x) {
        int count = 0;
        while (x!=0) {
            x = (x & (x << 1));
            count++;
        }
        return count;
    }
}
