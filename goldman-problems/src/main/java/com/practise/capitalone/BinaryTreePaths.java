package com.practise.capitalone;

/*
* Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
* */


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        //can be solved using DFS as have to trave all the nodes
        List<String> result = new ArrayList<>(); //result

        if(root == null){
            return result;
        }

        dfs(root, "", result);

        return result;
    }

    //traverse through all the child
    private void dfs(TreeNode node, String path, List<String> result) {
        if(node == null){
            return;
        }

        //append value
        path = path + node.val;

        if(node.left == null && node.right == null){
            result.add(path);
        }
        path = path + "->";

        //traverse through both the sides
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
