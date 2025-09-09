package com.practise.goldman_problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelTraversal {
    /*
    * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
    * (i.e., from left to right, then right to left for the next level and alternate between).
        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[20,9],[15,7]]

        Example    2:
        Input: root = [1]
        Output: [[1]]

        * Example 3:
            Input: root = []
            Output: []
            *
Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
    * */

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // return empty if null
        if (root == null) {
            return result;
        }

        //lets set a flat to process one time left and one time right
        boolean leftToRight = true;
        //our main ask here is how we can process the elements of bst in zigzag manner remove and add elemnts
        Queue<TreeNode> queue = new LinkedList<>(); // why linkedlist gives me ability to add first or last with O(1)
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); //size of the level
            List<Integer> elementsOfLevel = new LinkedList<>(); //O(1)

            //elementsOfLevel.add(queue.element().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    elementsOfLevel.addLast(node.val);
                } else {
                    elementsOfLevel.addFirst(node.val);
                }

                //process all the children of the root
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(elementsOfLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        ZigzagLevelTraversal test = new ZigzagLevelTraversal();
        List<List<Integer>> lists = test.zigzagLevelOrder(root1);
        System.out.printf("Exaple : %s%n", lists);
    }
}
