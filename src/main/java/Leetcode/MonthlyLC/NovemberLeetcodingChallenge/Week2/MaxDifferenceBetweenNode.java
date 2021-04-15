package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week2;

public class MaxDifferenceBetweenNode {
    public static class TreeNode {
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

    // int max = Integer.MIN_VALUE;
    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {

        if (root == null)
            return  0;

        solve(root, root.val, root.val);
        return res;
    }

    private void solve(TreeNode root, int min, int max) {

        if (root.left == null && root.right == null) {
            res = Math.max(res, max - min);
            return;
        }

        if (root.left != null) {
            solve(root.left, Math.min(min, root.left.val), Math.max(max, root.left.val));
        }
        if (root.right != null) solve(root.right, Math.min(min, root.right.val), Math.max(max, root.right.val));

        res = Math.max(res, max - min);
    }


}
