package org.example;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 */
public class MinStack13 {

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        minStack.getMin();
    }

    public static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack(){
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val){
            stack.push(val);
            val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
            minStack.push(val);
        }

        public void pop(){
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
