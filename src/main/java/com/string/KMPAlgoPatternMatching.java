package com.string;

import java.util.Arrays;

public class KMPAlgoPatternMatching {
	public static void main(String[] args) {
		String str = "AAABAAAAC";
		int[] lpsArray= new int[str.length()];
		lpsArray(str, lpsArray);
		System.out.println(Arrays.toString(lpsArray));

	}


	static void lpsArray(String str, int[] arr) {
		int len=0;
		int curr=1;
		while(curr < arr.length) {
			if(str.charAt(curr) == str.charAt(len)) {
				len++;
				arr[curr]=len;
				curr++;
			}else {
				if(len==0) {
					arr[curr]=len;
					curr++;
				}else {
					len=arr[len-1];
				}

			}
		}

	}

}
