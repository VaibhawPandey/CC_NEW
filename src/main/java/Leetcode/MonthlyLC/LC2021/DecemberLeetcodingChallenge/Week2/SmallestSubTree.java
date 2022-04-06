package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week2;

public class SmallestSubTree {
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

   class Pair {
        int maxDepth;
        TreeNode node;

        Pair(int maxDepth, TreeNode node) {
            this.maxDepth = maxDepth;
            this.node = node;
        }
   }

    TreeNode res = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        if (root == null)
            return res;

        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {

        if (root == null)
            return new Pair(0, null);

        Pair left = dfs(root.left), right = dfs(root.right);

        int d1 = left.maxDepth, d2 = right.maxDepth;
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root: d1 > d2 ? left.node: right.node);
    }
}
