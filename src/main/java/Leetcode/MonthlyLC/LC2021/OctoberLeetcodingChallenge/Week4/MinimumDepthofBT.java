package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week4;

public class MinimumDepthofBT {
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
    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        return minDepthUtil(root, 1);
    }

    private int minDepthUtil(TreeNode root, int depth) {

        if (root.left == null && root.right == null)
            return depth;

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (root.left != null) left = minDepthUtil(root.left, depth + 1);
        if (root.right != null) right = minDepthUtil(root.right, depth + 1);

        return Math.min(left, right);
    }
}
