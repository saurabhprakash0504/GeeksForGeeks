package com.bitoperator;

public class PowerCheckMethod3 {
	public static void main(String[] args) {
		int num = 0 ;
		int counter=0;
		do {
			num = num & (num-1);
			counter++;
		}while(num != 0 || counter == 2);
		System.out.println("num >> "+num);
		if(counter == 1)
		System.out.println(" num is power ");
		else
			System.out.println("num is not power ");
	}
}
