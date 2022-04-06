package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week3;

public class ValidateBST {
    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        return solve(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean solve(TreeNode root, int minValue, int maxValue) {

        if (root.left == null && root.right == null)
            return true;

        boolean left = true, right = true;

        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val >= minValue)
                left = false;
            else {
                // minValue = root.left.val;
                left = solve(root.left, root.left.val, maxValue);
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val <= maxValue)
                right = false;
            else
                right = solve(root.right, minValue, root.right.val);
        }

        return left & right;
    }

}
