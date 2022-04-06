package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week2;

public class BinaryTreeTilt {

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

    public static void main(String[] args) {

        TreeNode leftNode = new TreeNode(7);
        leftNode.left = new TreeNode(1); leftNode.right = new TreeNode(1);
        leftNode.left.left = new TreeNode(3);
        leftNode.left.right = new TreeNode(3);
        leftNode.left.left.left = null; leftNode.left.left.right = null;
        leftNode.left.right.left = null; leftNode.left.right.right = null;
        leftNode.right.left = null; leftNode.right.right = null;
        TreeNode rightNode = new TreeNode(14);
        rightNode.left = new TreeNode(2); rightNode.right = new TreeNode(2);
        rightNode.left.left = null; rightNode.left.right = null;
        rightNode.right.left = null; rightNode.right.right = null;

        TreeNode root = new TreeNode(21, leftNode, rightNode);
        new BinaryTreeTilt().findTilt(root);
    }

    int sum = 0;
    public int findTilt(TreeNode root) {

        if (root == null)
            return 0;

        solve(root);
        return sum;
    }

    private int solve(TreeNode root) {

        if (root.left == null && root.right == null)
            return root.val;


        int left = root.left != null ? solve(root.left): 0;
        int right = root.right != null ? solve(root.right): 0;
        int subSetSum = root.val + left + right;

        sum += Math.abs(left - right);
        return subSetSum;
    }
}
