package com.searching;

public class Count1InSortedArray {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int[] arr = { 1, 0, 0, 0, 0, 0 };
		//System.out.println(count(arr));
		System.out.println(countOnes(arr.length,arr));
		long endTime = System.nanoTime();

		long durationInNano = (endTime - startTime);

		System.out.println("timelapsed " + durationInNano);
	}

	static int count(int[] arr) {
		if (arr[arr.length - 1] == 1) {
			return arr.length;
		}
		if (arr[0] == 0) {
			return 0;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			// System.out.println("mid >> " + mid);
			if (arr[mid - 1] == 1 && arr[mid] == 0) {
				return mid;
			} else if (arr[mid] == 1) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return 0;
	}


public static int countOnes(int n,int[] arr){

        int low = 0, high = n-1;

        int mid = (low+high)/2;

        // Binary Search
        while(low <= high){

            mid = (low + high)/2;

            // if mid is 1, then check for upper half
            if(arr[mid] == 1 && mid+1 < n && arr[mid+1] == 1){
                low = mid+1;
            }

            // if mid is 0, then iterate for upper half
            else if(arr[mid] == 0){
                high = mid-1;
            }

            // else, iterate for lower half
            else if(arr[mid] == 1 && ((mid+1 < n && arr[mid+1] == 0) || (mid == n-1))){
                return mid+1;
            }

        }
        return 0;
    }
}
