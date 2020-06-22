package com.bitoperator;

public class CheckKthBitSetOrNot {

	public static void main(String[] args) {
		int num = 4;
		int bit = 1;
		
		if(((num >> (bit-1)) & 1)==1){
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}

}
