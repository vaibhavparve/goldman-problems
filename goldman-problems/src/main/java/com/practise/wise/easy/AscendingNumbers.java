package com.practise.wise.easy;

public class AscendingNumbers {

    public boolean areNumbersAscending(String s) {
        String[] wordArray = s.split(" ");
        int prev = -1;
        for (String word : wordArray) {
            if (isNum(word)) {
                int current = Integer.parseInt(word);
                if (current <= prev) {
                    return false;
                }
                prev = current;
            }
        }
        return true;
    }

    boolean isNum(String word) {
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
