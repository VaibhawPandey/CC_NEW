package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week3;

import java.util.ArrayDeque;
import java.util.Queue;

public class RangeSumBST {
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
    public int rangeSumBST(TreeNode root, int low, int high) {

        int res = 0;
        if (root == null)
            return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val >= low && temp.val <= high) res += temp.val;
            if (temp.left != null && temp.val > low) queue.add(temp.left);
            if (temp.right != null && temp.val < high) queue.add(temp.right);
        }

        return res;
    }
}
