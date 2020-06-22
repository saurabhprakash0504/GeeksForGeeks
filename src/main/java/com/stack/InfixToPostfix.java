package com.stack;

import java.util.Stack;

public class InfixToPostfix {
	public static void main(String[] args) {
		String input = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(input));
	}

	public static int prec(char ch) {
		switch (ch) {
		    case '+':
		    case '-':
		        return 1;
		    case '*':
		    case '/':
			    return 2;
		    case '^':
			    return 3;
		}
		return -1;
	}

	// The main function to convert infix expression
    //to postfix expression
	public static String infixToPostfix(String exp) {
		String result = new String("");
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i<exp.length(); ++i) {
			char c = exp.charAt(i);

			// If the scanned character is an operand, add it to output string.
			if (Character.isLetterOrDigit(c))
				result += c;

			// If the scanned character is an ‘(‘, push it to the stack.
			else if (c == '(')
				stack.push(c);

			// If the scanned character is an ‘)’, pop and to output string from the stack
            // until an ‘(‘ is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			}
			// If an operator is scanned
			else {
				while (!stack.isEmpty() && prec(c) <= prec(stack.peek()))
					result += stack.pop();
				stack.push(c);
			}

		}
		while (!stack.isEmpty())
			result += stack.pop();
		return result;
	}
}
