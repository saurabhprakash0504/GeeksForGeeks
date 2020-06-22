package com.stack;

import java.util.Stack;

public class ParathesisProblem {
	public static void main(String[] args) {
		System.out.println(checkParathesis("{([])}"));
		System.out.println(ispar("{([])}"));
		System.out.println(ispar2("{([])}"));
	}

	static boolean checkParathesis(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				char c = stack.pop();
				if (c == '[' && str.charAt(i) != ']') {
					return false;
				} else if (c == '(' && str.charAt(i) != ')') {
					return false;
				} else if (c == '{' && str.charAt(i) != '}') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	static boolean ispar(String x) {
		Stack<Character> s = new Stack<Character>();
		s.push(x.charAt(0));
		for (int i = 1; i < x.length(); i++) {
			if (x.charAt(i) == '}') {
				if (s.pop() != '{') {
					return false;
				}
				continue;
			} else if (x.charAt(i) == ']') {
				if (s.pop() != '[') {
					return false;
				}
				continue;
			} else if (x.charAt(i) == ')') {
				if (s.pop() != '(') {
					return false;
				}
				continue;
			} else {
				s.push(x.charAt(i));
			}
		}

		if (s.isEmpty()) {
			return true;
		}
		return false;
	}

	static boolean ispar2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
