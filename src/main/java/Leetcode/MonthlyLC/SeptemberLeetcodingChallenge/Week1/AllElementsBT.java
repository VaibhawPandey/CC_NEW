package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week1;

import java.util.ArrayList;
import java.util.List;

public class AllElementsBT {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> res = new ArrayList<>();

        if (root1 != null) traverseList(root1, res);
        if (root2 != null) traverseList(root2, res);

        return res;
    }

    private List<Integer> traverseList(TreeNode root1, List<Integer> res) {

        res.add(root1.val);

        if (root1.left != null) traverseList(root1.left, res);
        if (root1.right != null) traverseList(root1.right, res);

        return res;
    }
}
