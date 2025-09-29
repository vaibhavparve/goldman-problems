package com.practise.bloomberg.medium;

import java.util.Stack;

/*
 * its simple problem maintain a stack and a boolean[] of index of () if valid
 * */
public class MinimumRemoveToMakeValidParanthesis {


    public String minRemoveToMakeValid(String s) {
        Stack<Integer> pars = new Stack<>(); //index of valid paranthesis
        Boolean[] valid = new Boolean[s.length()];
        //corner case
        if (s.isEmpty()) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            char paraChar = s.charAt(i);

            if (paraChar == '(') {
                pars.push(i);
            } else if (paraChar == ')') {
                if (!pars.isEmpty()) {
                    valid[pars.pop()] = true;
                    valid[i] = true;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != '(' || c != ')') {
                result.append(c);
            } else if (valid[i]) {
                result.append(c);
            }
        }
        return result.toString();
    }

    static void main() {
        MinimumRemoveToMakeValidParanthesis test = new MinimumRemoveToMakeValidParanthesis();
        System.out.println(test.minRemoveToMakeValid("a)b(c)d"));

    }
}
