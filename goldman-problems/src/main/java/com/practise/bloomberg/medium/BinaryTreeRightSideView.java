package com.practise.bloomberg.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //solving using DFS with recursion
        //edge case
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(node.val);
        }

        //process right side first
        dfs(node.right, result, depth + 1);
        dfs(node.left, result, depth + 1);
    }
}
