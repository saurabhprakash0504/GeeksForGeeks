package com.recurssion;

public class MaximumCutsInARope {
	public static void main(String[] args) {
		System.out.println((maxCut(5)));
	}

	static int maxCut(int ropeLength) {
		if (ropeLength == 0) {
			return 0;
		}
		if (ropeLength < 0) {
			return -1;
		}
		int first = maxCut(ropeLength - 2);
		int second = maxCut(ropeLength - 1);
		int third = maxCut(ropeLength - 5);
		
		int max = 0;
		if (first > second && first > third)
			max = first;
		else if (second > third)
			max = second;
		else
			max = third;

		
		System.out.println("m "+max);
		//return max;
		
		if (max == -1)
			return -1;
		else
			return max + 1;
			//*/
		
		//return max;
		//and making max+1 at the call side;
	}
}
