package com.practise.goldman_problems.medium;

public class DistributeCoinsInBST {

    static class TreeNode {
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

    /*main approach to follow is to know whether im in excess or deficit at a given node.
    *
    * DFS Post-order Traversal: We process children before parents to calculate excess/deficit coins bottom-up.
        Excess/Deficit Calculation: For each node, we calculate:
        excess = node.val + leftExcess + rightExcess - 1
        The -1 represents the coin this node needs to keep
        Move Counting: The number of moves through a node equals the sum of absolute values of excess coins from its children
    *       consider solving below famous example
    *           1
    *       0       0
    *           3
    *  */
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0; // if no child node
        }

        //calculate the excess for left node
        int leftExcess = dfs(root.left);
        int rightExcess = dfs(root.right);

        moves = moves + Math.abs(leftExcess) + Math.abs(rightExcess);

        // this function should return the excess for this node i.e, keep -1 for it and return others as number of moves
        return root.val + leftExcess + rightExcess - 1;
    }

    public static void main(String[] args) {
        DistributeCoinsInBST.TreeNode root1 = new DistributeCoinsInBST.TreeNode(1);
        root1.left = new DistributeCoinsInBST.TreeNode(0);
        root1.right = new DistributeCoinsInBST.TreeNode(0);
        root1.right.left = new DistributeCoinsInBST.TreeNode(3);

        DistributeCoinsInBST test = new DistributeCoinsInBST();
        System.out.printf("moves : %d%n", test.distributeCoins(root1));
    }
}
