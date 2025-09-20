package com.stack;

import java.util.*;

public class MaxRectangleAreaWith0And1 {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0}
        };

        System.out.println(maxArea(mat));
    }

    static int maxArea(int mat[][]) {
        // code here
        int width = mat[0].length;
        ArrayList<Integer> l = new ArrayList<Integer>(Collections.nCopies(width,0));
        ArrayList<Integer> nextSmaller = new  ArrayList<Integer>(Collections.nCopies(width,-1));
        ArrayList<Integer> prevSmaller = new  ArrayList<Integer>(Collections.nCopies(width,-1));

        int max = Integer.MIN_VALUE;

        for(int i=0;i< mat.length;i++){
            l = new ArrayList<Integer>(Collections.nCopies(width,0));
            nextSmaller = new  ArrayList<Integer>(Collections.nCopies(width,-1));
            prevSmaller = new  ArrayList<Integer>(Collections.nCopies(width,-1));

            findLargestNumberVertically(mat, i, l);

            findNextSmaller(l, nextSmaller);

            findPrevSmaller(l, prevSmaller);

            for(int j =0;j<mat[i].length;j++){
                if(nextSmaller.get(j) == -1){
                    nextSmaller.set(j, mat[i].length);
                }

                int length = l.get(j);
                int w = nextSmaller.get(j) - prevSmaller.get(j) - 1;

                int area = length * w;

                max = Integer.max(area, max);

            }
        }

        return max ;
    }


    static void findLargestNumberVertically(int[][] mat, int i,  ArrayList<Integer> l){

        int prevRow = i-1;

        for(int j =0;j< mat[i].length;j++){

            if(prevRow != -1){
                if(mat[i][j] == 1){
                    int prev = mat[prevRow][j];
                    mat[i][j]= prev +1;
                    l.set(j, prev +1);
                }else{
                    mat[i][j] = 0;
                    l.set(j, 0);
                }

            }else{

                if(mat[i][j] == 1){
                    l.set(j, 1);
                }else{
                    l.set(j, 0);
                }

            }
        }

    }


    static void findNextSmaller(ArrayList<Integer> l, ArrayList<Integer> nextSmaller ){

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        for(int i=l.size()-1;i>=0;i--){

            while(!stack.isEmpty() && stack.peek() != -1 && l.get(stack.peek()) >= l.get(i)){
                stack.pop();
            }

            nextSmaller.set(i, stack.peek());
            stack.push(i);


        }


    }


    static void findPrevSmaller(ArrayList<Integer> l, ArrayList<Integer> prevSmaller ){

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        for(int i= 0;i<=l.size()-1;i++){

            while(!stack.isEmpty() && stack.peek() != -1 && l.get(stack.peek()) >= l.get(i)){
                stack.pop();
            }

            prevSmaller.set(i, stack.peek());
            stack.push(i);


        }


    }
}
