package com.practise.bloomberg.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    //main thing to remember is when we will consider it valid when we have used all the length
    //important thing to ask, do we care about space complexity ?
    // problem can be solved with backtracking or iterative BFS

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int closed, int max) {
        //edge case where found the result string
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        //rule number 1. if open < max, process open
        if (open < max) {
            backtrack(result, current + '(', open + 1, closed, max);
        }

        if (closed < open) {
            backtrack(result, current + ')', open, closed + 1, max);
        }
    }

    static void main() {
        GenerateParanthesis test = new GenerateParanthesis();
        System.out.println(" generate : " + test.generateParenthesis(2));
    }


}
