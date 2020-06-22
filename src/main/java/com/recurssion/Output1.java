package com.recurssion;

public class Output1 {
	public static void main(String[] args) {
		check(3);
	}
	
	static void check(int num) {
		if(num == 0) {
			return ;
		}
		System.out.println(num);
		check(num-1);
		System.out.println(num);
	}
}
