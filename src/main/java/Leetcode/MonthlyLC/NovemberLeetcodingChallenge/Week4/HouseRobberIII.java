package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week4;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

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

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return solve(root, map);
    }

    private int solve(TreeNode root, Map<TreeNode, Integer> map) {

        if (root == null) return 0;

        if (map.containsKey(root)) return map.get(root);

        int val = 0;
        if (root.left != null) {
            val += solve(root.left.left, map) + solve(root.left.right, map);
        }

        if (root.right != null) {
            val += solve(root.right.left, map) + solve(root.right.right, map);
        }

        val = Math.max(val + root.val, solve(root.left, map) + solve(root.right, map));
        map.put(root, val);

        return val;
    }

}
