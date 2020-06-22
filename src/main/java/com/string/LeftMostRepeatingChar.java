package com.string;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class LeftMostRepeatingChar {
	public static void main(String[] args) {
		String s="abbccdd";
		System.out.println(findLeft(s));
		System.out.println(method2(s));
	}

	static int findLeft(String s) {
		LinkedHashMap<Character,Integer> h = new LinkedHashMap<Character,Integer>();
		int i=0;
		for(char c:s.toCharArray()) {
			if(h.containsKey(c)) {
				return h.get(c);
			}else {
				h.put(c, i);
			}
			i++;
		}
		return -1;
	}

	static int method2(String s) {
		HashSet<Character> h = new HashSet<Character>();
		for(char c:s.toCharArray()) {
			if(h.contains(c)) {
				return s.indexOf(c);
			}else {
				h.add(c);
			}
		}
		return -1;
	}
}
