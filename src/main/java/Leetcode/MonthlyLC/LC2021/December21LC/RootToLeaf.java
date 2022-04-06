package main.java.Leetcode.MonthlyLC.December21LC;

public class RootToLeaf {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(new RootToLeaf().sumNumbers(root));
    }
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
    public int sumNumbers(TreeNode root) {
        int count[] = { 0 };
        findSum(root, root.val, count);
        return count[0];
    }

    private void findSum(TreeNode node, int posCount, int[] count) {
       if (node.left == null && node.right == null) {
           count[0] += posCount;
           return;
       }

       if (node.left != null) findSum(node.left, posCount * 10 + node.left.val, count);
       if (node.right != null) findSum(node.right, posCount * 10 + node.right.val, count);
    }


}
