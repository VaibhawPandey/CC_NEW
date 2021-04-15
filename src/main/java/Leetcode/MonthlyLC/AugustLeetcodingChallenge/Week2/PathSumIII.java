package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

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

    public int pathSum(TreeNode root, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSumTree(root, 0, sum, map);
    }

    private int pathSumTree(TreeNode root, int sum, int target, Map<Integer, Integer> map) {

        if (root == null)
            return 0;

        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        res += pathSumTree(root.left, sum, target, map) + pathSumTree(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);

        return res;
    }
}
