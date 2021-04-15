package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week4;

public class BalancedBT {
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


    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        solve(root);

        return isBalanced;
    }

    private int solve(TreeNode root) {

        if (!isBalanced)
            return 0;

        if (root.left == null && root.right == null)
            return 0;

        int left = root.left == null ? 0: solve(root.left) + 1;
        int right = root.right == null ? 0: solve(root.right) + 1;

        int diff = Math.abs(left - right);
        if (diff > 1) isBalanced = false;

        return Math.max(left, right);
    }
}
