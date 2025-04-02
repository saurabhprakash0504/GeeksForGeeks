package com.array;

public class FindSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        //  int[] arr ={2,4};
        findSumArray(arr, 3);
    }

    static void findSumArray(int[] arr, int sum) {
        //   int temp[] = new int[arr.length];
        int left = 0;
        //  int currSum = arr[left];
        //  temp[0] = currSum;
       /* if (currSum == sum) {
            System.out.println("array >> " + arr[left]);
        }*/
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            // temp[i] = currSum;

            while (currSum > sum) {
                // int diff = currSum - temp[j];
                currSum = currSum - arr[left];

                left++;
            }
            if (currSum == sum) {
                System.out.println("found starting index second >> " + (left) + " right index " + i);
            }

        }

    }

}
