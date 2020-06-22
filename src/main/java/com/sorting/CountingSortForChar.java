package com.sorting;

public class CountingSortForChar {
	public static void main(String[] args) {


		//char[] seq= {'s','y','y','c','q','p'};
		String s="hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozv";
		char[] seq=s.toCharArray();
		countSort(seq);
	}

	public static void countSort(char seq[]) {
		int[] arr = new int[27];
		for (int i = 0; i < seq.length; i++) {
			int d = seq[i]-96;
			//System.out.println("value >> " + seq[i] + " d >>" + d);
			arr[d] = arr[d] + 1;
		}

		for (int j = 1; j < arr.length; j++) {
			arr[j] = arr[j - 1] + arr[j];
		}

		char[] temp = new char[seq.length];
		for (int i = seq.length - 1; i >= 0; i--) {
			int d = seq[i]-96;
			temp[arr[d] - 1] = seq[i];
			arr[d] = arr[d] - 1;

		}
		//System.out.println(Arrays.toString(temp));
		for(int i =0;i<temp.length;i++){
		    System.out.print(temp[i]);
		}
	}
}
