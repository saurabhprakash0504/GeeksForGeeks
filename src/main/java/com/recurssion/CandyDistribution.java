package com.recurssion;

public class CandyDistribution {
	public static void main(String[] args) {
		System.out.println(candyRem(5, 1000));
	}

	static int candyRem(int people, int candies) {
		int firstloop = 0;
		for (int i = 1; i <= people; i++) {
			firstloop = firstloop + i;
		}
		int div = candies / firstloop;
		int rem = candies - (div * firstloop);
		int j=1;
		while(j<=rem) {
			rem=rem-j;
			j++;
		}
		return rem;
	}
}
