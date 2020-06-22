package com.recurssion;

public class SubSetProblemRecurssion {
	public static void main(String[] args) {
		recurssive("abc", 0, "");
	}
	
	static void recurssive(String str, int index, String currStr) {
		if(index == str.length()) {
			System.out.println(currStr);
			return;
		}
		recurssive(str, index+1, currStr);
		recurssive(str, index+1, currStr+str.charAt(index));
	}
}
