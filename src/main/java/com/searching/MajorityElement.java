package com.searching;

public class MajorityElement {
	public static void main(String[] args) {
		int[] arr= {6,8,4,8,8};
		System.out.println(method1(arr));
	}

	static int method1(int[] arr) {
		int count=1;
		int num=arr[0];

		for(int i=1;i<arr.length;i++) {
			if(arr[i]==num) {
				count=count+1;
			}else {
				count=count-1;
				num=arr[i];
			}
		}

		count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==num) {
				count=count+1;
			}
		}

		if(count>(arr.length/2)) {
			return num;
		}

		return -1;
	}
}
