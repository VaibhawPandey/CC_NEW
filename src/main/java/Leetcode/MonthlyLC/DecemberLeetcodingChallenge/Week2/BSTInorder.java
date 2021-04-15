package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.List;

public class BSTInorder {

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

    List<Integer> nodeList = new ArrayList<>();
    int position = -1;

    public void BSTIterator(TreeNode root) {

        if (root == null)
            return;

        inorderTraversal(root);

    }

    private void inorderTraversal(TreeNode root) {

        if (root.left != null) inorderTraversal(root.left);
        nodeList.add(root.val);
        if (root.right != null) inorderTraversal(root.right);

    }

    public int next() {
       position++;
       return nodeList.get(position);
    }

    public boolean hasNext() {
        if (position == nodeList.size())
            return false;

        return true;
    }
}
