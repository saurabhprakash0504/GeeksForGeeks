package com.practice;

public class ArrayQuestion {

    /******************************************************************************

     Given a sorted array arr[] of size N, the task is to remove the duplicate elements from the array.

     Examples:

     Input: arr[] = {2, 2}
     Output: arr[] = {2,null}
     Explanation: All the elements are 2, So only keep one instance of 2.

     Input: arr[] = {1, 2, 2, 3, 4, 4 }
     Output: arr[] = {1, 2, 3, 4,null,null}
     *******************************************************************************/

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;

        // removeDuplicates() returns new size of array
        n = removeDuplicates(arr, n);

        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    static int removeDuplicates(int arr[], int n) {
        int prev = arr[0];
        int[] temp = new int[n];
        temp[0] = arr[0];
        int freq = 0;
        int ind = 1;

        for (int i = 1; i < arr.length; i++) {
            System.out.println("arr[i] " + arr[i] + " temp[ind] " + temp[ind] + "freq " + freq);
	       /* if( arr[i] == prev  && freq > 2){
	           // System.out.print("Inside");
	            freq++;
	            continue;
	        }else*/
            if (arr[i] == prev && freq <= 2) {
                temp[ind] = arr[i];
                prev = arr[i];
                freq++;
                ind++;
            } else {

                temp[ind] = arr[i];

                prev = arr[i];
                ind++;
                freq++;
                if (freq > 2) {
                    freq = 0;
                }
                //freq=1;

            }
        }

        for (int i = 0; i < ind; i++) {
            arr[i] = temp[i];
        }

	  /*  for(int i=ind+1;i< temp.length;i++){
	        arr[i]= 0;
	    }*/

        return ind;

    }


}

