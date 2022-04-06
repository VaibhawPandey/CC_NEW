package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week2;

public class SumToRoot {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumRootToLeaf(TreeNode root) {

        return sumRootToLeafUtil(root, 0);
    }

    private int sumRootToLeafUtil(TreeNode root, int sum) {

        if (root == null)
            return 0;

        sum = sum * 2 + root.val;

        if (root.left == null && root.right == null)
            return sum;

        return sumRootToLeafUtil(root.left, sum) + sumRootToLeafUtil(root.right, sum);
    }


}
