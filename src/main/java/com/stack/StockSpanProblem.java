package com.stack;

import java.util.Stack;

public class StockSpanProblem {
	public static void main(String[] args) {
		int[] arr = { 15, 13, 12, 14, 16, 8, 6, 4, 10, 30 };
		// OUTPUT :: 1,1,1,3,5,1,1,1,4,10
		stockSpan(arr);
		stockSpan2(arr);
	}

	static void stockSpan(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j]) {
					break;
				}
				count++;
			}
			System.out.print(count + " ");
		}
	}

	static void stockSpan2(int[] arr) {
		System.out.println("");
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		System.out.print("1 ");
		for(int i=1;i<arr.length;i++) {
			Integer value = stack.peek();
			if(arr[value] > arr[i] ) {
				System.out.print("1 ");
				stack.push(i);
			}else {
				while(!stack.isEmpty() && arr[value]<arr[i]) {
					stack.pop();
					if(!stack.isEmpty())
						value=stack.peek();
				}
				if(stack.isEmpty()) {
					System.out.print((i+1)+" ");
				}else {
					System.out.print((i-value)+" ");
				}
				stack.push(i);

			}
		}

	}


}
