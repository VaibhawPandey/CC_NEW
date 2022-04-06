package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week1;

public class InsertIntoBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right){
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertVal(root, val);
    }

    private TreeNode insertVal(TreeNode root, int val) {

        if (root == null) {
            root = new TreeNode(val, null, null);
            return root;
        }

        if (root.val > val)
            root.left = insertVal(root.left, val);
        else
            root.right = insertVal(root.right, val);

        return root;
    }
}
