package com.stack;

import java.util.Stack;

public class GetMinfromStack {

    public static void main(String[] args) {
        GetMinfromStack s = new GetMinfromStack();
        s.push(10);
        s.push(20);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }

    Stack<Integer> stack ;
    int min = Integer.MAX_VALUE;
    public GetMinfromStack() {
        // Define Stack
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        // Add an element to the top of Stack
        if(x < min){
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(min == stack.peek()){
            stack.pop();
            int tempVal = Integer.MAX_VALUE;
            Stack<Integer> temp = new Stack();
            while(!stack.isEmpty()){
                tempVal = Integer.min(tempVal, stack.peek());
                temp.push(stack.pop());
            }

            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
            min = tempVal;
        }else{
            stack.pop();
        }

    }

    public int peek() {
        // Returns top element of the Stack
        if(isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    boolean isEmpty() {
        // Check if the stack is empty
        if (stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getMin() {
        // Finds minimum element of Stack
        if(isEmpty()){
            return -1;
        }
        return min;
    }
}
