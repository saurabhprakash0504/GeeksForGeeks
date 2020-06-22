package com.recurssion;

public class CheckIfPallindrome {
	public static void main(String[] args) {
		String input="aaabaaa";
		String output = (check(input, input.length()-1, ""));
		if(input.equals(output)) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}

	static String check(String s, int i, String rev) {
		//System.out.println(rev + "");
		if (i == -1) {
			return rev;
		}
		char c = s.charAt(i);
		rev = rev + c;
		i=i-1;
		return check(s, i, rev);
	}
}
