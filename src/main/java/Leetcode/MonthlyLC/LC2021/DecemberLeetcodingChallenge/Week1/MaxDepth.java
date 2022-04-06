package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week1;

public class MaxDepth {

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


    public int maxDepth(TreeNode root) {

        int maxDepth = 0;
        if (root == null)
            return maxDepth;

        return dfs(root, 0, maxDepth);
    }

    private int dfs(TreeNode root, int level, int maxDepth) {

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, level + 1);
            return maxDepth;
        }

        int leftDepth = root.left != null ? dfs(root.left, level + 1, maxDepth): 0;
        int rightDepth = root.right != null ? dfs(root.right, level + 1, maxDepth): 0;

        return Math.max(leftDepth, rightDepth);
    }
}
