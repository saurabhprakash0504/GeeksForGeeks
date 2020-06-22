package com.matrix;

public class JaggedArray {
	public static void main(String[] args) {
		int[][] arr=new int[3][];
		for(int i=0;i<arr.length;i++) {
			arr[i]= new int[i+1];
			for(int j=0;j<i;j++) {
				arr[i][j]=i;
			}
		}

		// printing value
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}
}
