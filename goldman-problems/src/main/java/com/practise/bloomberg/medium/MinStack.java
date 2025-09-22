package com.practise.bloomberg.medium;

import java.util.Stack;

public class MinStack {
    //its easiest medium problem so far
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        //check if stack is empty
        if (stack.isEmpty()) {
            return;
        }

        Integer pop = stack.pop();
        if (minStack.peek().equals(pop)) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
