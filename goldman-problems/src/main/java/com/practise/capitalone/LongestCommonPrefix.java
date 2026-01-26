package com.practise.capitalone;

public class LongestCommonPrefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        class TrieNode {
            TrieNode[] children = new TrieNode[10];
        }

        TrieNode root = new TrieNode(); //start with empty
        for (int num : arr1) {
            TrieNode node = root;
            String numStr = String.valueOf(num);

            for (char ch : numStr.toCharArray()) {
                int digit = ch - '0';
                if (node.children[digit] == null) {
                    node.children[digit] = new TrieNode();
                }
                node = node.children[digit];
            }
        }

        int maxLength = 0;

        for (int num : arr2) {
            TrieNode node = root;
            int currentLength = 0;
            String numStr = String.valueOf(num);

            for (char ch : numStr.toCharArray()) {
                int digit = ch - '0';
                if (node.children[digit] == null) {
                    break;
                }
                currentLength++;
                node = node.children[digit];
            }
            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;
    }
}
