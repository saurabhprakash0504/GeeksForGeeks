package com.string;

public class KeyPadTyingExample {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		s = s.toUpperCase();
		System.out.println(keyPadMethod1(s));
		System.out.println(keyPadMethod2(s));
	}

	static String keyPadMethod1(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (c >= 65 && c <= 67) {
				result = result + "2";
			} else if (c >= 68 && c <= 70) {
				result = result + "3";
			} else if (c >= 71 && c <= 73) {
				result = result + "4";
			} else if (c >= 74 && c <= 76) {
				result = result + "5";
			} else if (c >= 77 && c <= 79) {
				result = result + "6";
			} else if (c >= 80 && c <= 83) {
				result = result + "7";
			} else if (c >= 84 && c <= 86) {
				result = result + "8";
			} else if (c >= 87 && c <= 90) {
				result = result + "9";
			}
		}
		return result;
	}

	static String keyPadMethod2(String s) {
		int[] arr= new int[26];
		int j=2;
		for(int i=0;i<arr.length-1;) {
			arr[i]=j;
			arr[i+1]=j;
			arr[i+2]=j;
			i=i+3;
			if((i==18 || i==25)) {
				arr[i]=j;
				i++;
			}
			j++;
		}
		String result="";
		for(int i=0;i<s.length();i++) {
			int cha = s.charAt(i)-97;
			result=result+arr[cha];
		}
		return result;
	}
}
