package com.stack;

import java.util.Stack;

public class MaxAreaOfHistoram {
	public static void main(String[] args) {
		long[] hist= {7 ,2 ,8 ,9 ,1 ,3 ,6 ,5};
		System.out.println(getMaxArea(hist,hist.length));
	}

	 public static long getMaxArea(long hist[], long n)  {
	        Stack<Integer> stack = new Stack<Integer>();
	        int max=0;
	        int top=0;
	        int curr=0;
	        int i;
	        for( i=0;i<n;){
	            if(stack.isEmpty() || hist[stack.peek()]<hist[i] ){
	                stack.push(i);
	                i++;
	            }else{
	                top = stack.pop();
	                if(stack.isEmpty()){
	                    curr= (int) (hist[top] * i);
	                }else{
	                    curr = (int) (hist[top]*(i-stack.peek()-1));
	                }
	                if(curr>max){
	                    max=curr;
	                }
	            }
	        }

	        while(!stack.isEmpty()){
	            top = stack.pop();
	                if(stack.isEmpty()){
	                    curr= (int) (hist[top] * i);
	                }else{
	                    curr = (int) (hist[top]*(i-stack.peek()-1));
	                }
	                if(curr>max){
	                    max=curr;
	                }
	        }
	        return max;
	    }
}
