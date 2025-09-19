package com.stack;

import java.util.*;

public class HistogramMaxRectangularArea {

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(getMaxArea(arr));
    }

    public static int getMaxArea(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> nextSmallerList = new ArrayList<Integer>(Collections.nCopies(n, -1));
        ArrayList<Integer> prevSmallerList = new ArrayList<Integer>(Collections.nCopies(n, -1));

        findNext(arr, nextSmallerList);
        findPrev(arr, prevSmallerList);

        int max = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){

            int width = nextSmallerList.get(i) - prevSmallerList.get(i) - 1;
            int height = arr[i];

            max = Integer.max(max, width * height);

        }

        return max;


    }


    static void findNext(int[] arr, ArrayList<Integer> list){

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        int n = arr.length;


        for(int i=arr.length-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek() != -1 && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            //This was the error
            if(stack.peek() == -1){
                list.set(i, arr.length);
            } else {
                list.set(i, stack.peek());
            }
            stack.push(i);
        }

    }


    static void findPrev(int[] arr, ArrayList<Integer> list){

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        int n = arr.length;


        for(int i=0;i<arr.length;i++){

            while(!stack.isEmpty() && stack.peek() !=-1 && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            list.set(i, stack.peek());
            stack.push(i);
        }




    }


}
