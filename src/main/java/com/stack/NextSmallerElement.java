package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {

        int[] arr = {4,5,2,10,8};
        ArrayList<Integer> res = nextSmallerEle(arr);
        System.out.println(res);

    }
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        return find(arr, stack);
    }


    static ArrayList<Integer> find(int[] arr, Stack<Integer> stack){

        int n = arr.length;

        ArrayList<Integer> list = new ArrayList<Integer>(Collections.nCopies(n, -1));


        for(int i=arr.length-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            list.set(i, stack.peek());
            stack.push(arr[i]);
        }


        //  Collections.reverse(list);

        return list;

    }
}
