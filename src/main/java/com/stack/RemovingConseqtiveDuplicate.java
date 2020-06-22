package com.stack;

import java.util.Stack;

public class RemovingConseqtiveDuplicate {
	public static void main(String[] args) {
		System.out.println(removeConsecutiveDuplicates("aaaaaabaabccccccc"));
	}

	public static String removeConsecutiveDuplicates(String str) {
		//Stack<Character> stack = new Stack<Character>();
//		stack.push(str.charAt(0));
		StringBuffer sb = new StringBuffer();
		sb.append(str.charAt(0));
		char last = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			/*
			 * if(stack.peek()!=str.charAt(i)){ stack.push(str.charAt(i)); }
			 */
			if (last != str.charAt(i)) {
				sb.append(str.charAt(i));
				last = str.charAt(i);
			}
		}
		return sb.toString();
	}


	public static String removeConsecutiveDuplicates2(String str) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(str.charAt(0));
		String s ="";
			s=	 str.charAt(0)+s;
		for (int i = 1; i < str.length(); i++) {

			  if(stack.peek()!=str.charAt(i)){
				  stack.push(str.charAt(i));
				  s =str.charAt(i)+s;
				 }


		}
		return s;
	}

}
