package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week1;


public class IncreasingOrderSearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode head = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {

        if (root == null)
            return head;

        TreeNode mainRoot = head;
        solve(root);

        return mainRoot;
    }

    private void solve(TreeNode root) {

        if (root.left != null) solve(root.left);
        if (head == null) {
            head = new TreeNode(root.val);
        } else {
            head.left = null;
            head.right = new TreeNode(root.val);
            head = head.right;
        }
        if (root.right != null) solve(root.right);
    }
}
