package com.practise.bloomberg.medium;

import java.util.Objects;
import java.util.Stack;

public class RemoveAdjacentDuplicate {
    public String removeDuplicates(String s) {
        Stack<Character> chars = new Stack<>();

        for (char c : s.toCharArray()) {
            //if the stack contains the char then remove the
            if (!chars.isEmpty() && chars.peek() == c) {
                chars.pop();
            } else {
                chars.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!chars.isEmpty()) {
            result.insert(0, chars.pop());
        }
        return result.toString();
    }
    class PairChar {
        Character c;
        Integer count;

        public PairChar(Character c, Integer count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicatesK(String s, Integer k) {
        Stack<PairChar> chars = new Stack<>();

        for (char c : s.toCharArray()) {
            //if the stack contains the char then remove the
            if (!chars.isEmpty() && chars.peek().c == c) {
                chars.peek().count++;
            } else {
                chars.push(new PairChar(c, 1));
            }
        }

        StringBuilder result = new StringBuilder();
        for (PairChar c : chars) {
            if (Objects.equals(c.count, k)) {
                chars.remove(c);
            } else {
                result.append(String.valueOf(c.c).repeat(c.count));
            }
        }

        return result.toString();
    }




    static void main() {
        RemoveAdjacentDuplicate test = new RemoveAdjacentDuplicate();

        System.out.println(STR."remove \{test.removeDuplicates("abbaca")}");
    }
}
