package com.practise.bloomberg.medium;

import java.util.Stack;

public class BrowserHistory {

    // this is simple task we can do this using 2 stacks one for forward and one for backward
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = homepage;
    }

    public void visit(String url) {
        backStack.push(currentPage); //push home page to back
        currentPage = url;
        forwardStack.clear();
    }

    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) { //go back n steps or the last in the back which ever is min
            currentPage = backStack.pop();
            forwardStack.add(currentPage);
            steps--;
        }
        return currentPage;
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            currentPage = forwardStack.pop();
            backStack.push(currentPage);
            steps--;
        }
        return currentPage;
    }
}
