package com.stack;

public class ImplementTwoStackInAnArray {
	static int[] arr = new int[3];
	static int top1 = -1;
	static int top2 = arr.length;

	public static void main(String[] args) {
		push1(10);
		push2(20);
		//pop1();
		//push2(30);
		//push2(40);
		//push2(50);
		//pop2();

		print();
	}

	private static void print() {
		for(int i=0;i<=top1;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=arr.length-1;i>=top2;i--) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void push1(int i) {
		if (top1 + 1 < top2) {
			arr[top1 + 1] = i;
			top1++;
		}

	}

	private static void push2(int i) {
		if (top1 < top2 - 1) {
			arr[top2 - 1] = i;
			top2--;
		}
	}

	private static int pop1() {
		int value = -1;
		if (top1 != -1) {
			value = arr[top1];
			top1--;
		}
		return value;
	}

	private static int pop2() {
		int value = -1;
		if (top2 != arr.length) {
			value = arr[top2];
			top2++;
		}
		return value;

	}

}
