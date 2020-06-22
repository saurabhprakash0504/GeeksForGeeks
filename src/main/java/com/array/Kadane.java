package com.array;
class Kadane{
    public static void main(String[] args) {
    	int[] arr = { -8, -9, -11 };
    	System.out.println(circularSubarraySum(arr, arr.length));
	}
    // finding the subarray with max sum
    static int  circularSubarraySum(int a[], int n) 
    { 
        //int n = a.length; 
         //boolean flag  = false;
        int count =0;
        int maxx = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(a[i] > maxx)
              maxx = a[i];
            if(a[i] < 0)
              count++;
        }
        if(count == n)
          return maxx;
  
        // Case 1: get the maximum sum using standard kadane' 
        // s algorithm 
        int max_kadane = kadane(a); 
  
        // Case 2: Now find the maximum sum that includes 
        // corner elements. 
        int max_wrap  =  0; 
        for (int i = 0; i < n; i++) 
        { 
            max_wrap += a[i]; // Calculate array-sum 
            a[i] = -a[i];  // invert the array (change sign) 
        } 
  
        // max sum with corner elements will be: 
        // array-sum - (-max subarray sum of inverted array) 
        System.out.println("max >> "+max_wrap);
        System.out.println("kadane(a) >> "+kadane(a));
        max_wrap = max_wrap + kadane(a); 
  
        // The maximum circular sum will be maximum of two sums 
        return (max_wrap > max_kadane)? max_wrap: max_kadane; 
    } 
  
    // Standard Kadane's algorithm to find maximum subarray sum 
    // See https://www.geeksforgeeks.org/archives/576 for details 
    static int kadane (int a[]) 
    { 
        int n = a.length; 
        int max_so_far = 0, max_ending_here = 0; 
        for (int i = 0; i < n; i++) 
        { 
            max_ending_here = max_ending_here + a[i]; 
            if (max_ending_here < 0) 
                max_ending_here = 0; 
            if (max_so_far < max_ending_here) 
                max_so_far = max_ending_here; 
        } 
        System.out.println("val");
    	for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
        
        return max_so_far; 
    }  
    
}

