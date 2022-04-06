package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

import java.util.*;

public class VerticalOrderTreversal {

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

    class Pair {
        int key;
        TreeNode value;

        Pair(int key, TreeNode value) {
            this.key = key;
            this.value = value;
        }
    }

    TreeMap<Integer, TreeMap<Integer, TreeNode>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> out = new ArrayList<>();
        map = new TreeMap<>();

        verticalTraversalTree(root, 0, 0);


        return out;
    }

    private void verticalTraversalTree(TreeNode root, int position, int level) {


    }

//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//
//        List<List<Integer>> out = new ArrayList<>();
//        if (root == null)
//            return out;
//
//        int lowestIndex = 0;
//
//        List<Integer> positionList = new ArrayList<>();
//        Queue<Pair> queue = new ArrayDeque<>();
//        queue.add(new Pair(0, root));
//
//        while (!queue.isEmpty()) {
//
//            Pair temp = queue.poll();
//            int position = temp.key;
//            if (!positionList.contains(position)) {
//                positionList.add(position);
//                if (position < 0)
//                    out.add(0, new ArrayList<>());
//                else
//                    out.add(new ArrayList<>());
//            }
//
//            lowestIndex = Math.min(lowestIndex, position);
//            out.get(position - lowestIndex).add(root.val);
//
//            if (temp.value.left != null) queue.add(new Pair(position - 1, temp.value.left));
//            if (temp.value.right != null) queue.add(new Pair(position + 1, temp.value.right));
//
//        }
//
//        return out;
//    }


}
