package com.string;

import java.util.HashMap;

public class Anagram {
	public static void main(String[] args) {
		String a="aabcd";
		String b= "abbcd";
		System.out.println(check(a,b));

	}

	static boolean check(String a, String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		for(char c: a.toCharArray()) {
			if(h.containsKey(c)) {
				h.put(c, h.get(c)+1);
			}else {
				h.put(c, 1);
			}
		}
		for(int i=0;i<b.length();i++) {
			if(h.containsKey(b.charAt(i))) {
				int val= h.get(b.charAt(i));
				if(val==1) {
					h.remove(b.charAt(i));
				}else {
					h.put(b.charAt(i), val-1);
				}
			}else {
				return false;
			}
		}
		return true;
	}
}
