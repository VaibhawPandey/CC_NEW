package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week4;



public class SumLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;

        return findSum(root, false);
    }

    private int findSum(TreeNode root, boolean flag) {

        if (root.left == null && root.right == null && flag)
            return root.val;

        int left = 0, right = 0;
        if (root.left != null) left = findSum(root.left, true);
        if (root.right != null) right = findSum(root.right, false);

        return left + right;
    }
}
