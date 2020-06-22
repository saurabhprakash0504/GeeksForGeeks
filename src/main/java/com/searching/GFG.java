package com.searching;

class GFG {
	public static void main(String[] args) {
		int[] arr = {1,0,0,1,1};
		int zero = 0;
		int nonZero = arr.length - 1;
		int count = 0;
		while (zero < nonZero) {
			for (int i = nonZero; i >= zero; i = i - 1) {
				count++;
				if (arr[i] != 0) {
					nonZero = i;
					break;
				}
				nonZero=-1;
			}
			System.out.println("zero  " + zero + " nonZero " + nonZero);
			for (int i = zero; i <= nonZero; i++) {
				count++;
				if (arr[i] == 0) {
					zero = i;
					break;
				}
				zero = i;
			}

			if (zero < nonZero) {
				int temp = arr[zero];
				arr[zero] = arr[nonZero];
				arr[nonZero] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("count << " + count);
	}
}