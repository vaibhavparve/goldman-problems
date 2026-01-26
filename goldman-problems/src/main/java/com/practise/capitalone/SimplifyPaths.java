package com.practise.capitalone;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPaths {

    public String simplifyPath(String path) {
        //best practice to use Deque instead of stack ds
        Deque<String> stack = new ArrayDeque<>();

        String[] components = path.split("/"); //split takes care of creating different strings, and handling multiple //

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }

            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(component);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.toString();
    }
}
