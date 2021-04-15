package main.java.Leetcode.WeeklyContest.WC209;


import java.util.ArrayDeque;
import java.util.Queue;

public class EvenOdd {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    class Node {
        TreeNode treeNode;
        int level;

        Node(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }
    public boolean isEvenOddTree(TreeNode root) {

        if (root == null)
            return true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root, 0));
        int lastSameLevelNumber = Integer.MAX_VALUE;
        int lastLevel = -1;
        boolean flagRes = true;

        while (!queue.isEmpty()) {
            Node parent = queue.poll();

            if ((parent.level % 2 == 0 && parent.treeNode.val % 2 == 0) ||
                    (parent.level % 2 != 0 && parent.treeNode.val % 2 != 0)) {
                flagRes = false;
                break;
            }

            if (parent.treeNode.left != null) queue.add(new Node(parent.treeNode.left, parent.level + 1));
            if (parent.treeNode.right != null) queue.add(new Node(parent.treeNode.right, parent.level + 1));

           if (parent.level == lastLevel) {
               if (lastSameLevelNumber % 2 == 0) {
                   if (lastSameLevelNumber >= parent.treeNode.val) {
                       flagRes = false;
                       break;
                   }
               } else {
                   if (lastSameLevelNumber <= parent.treeNode.val) {
                       flagRes = false;
                       break;
                   }
               }
           }
            lastLevel = parent.level;
            lastSameLevelNumber = parent.treeNode.val;
        }

        return flagRes;
    }
}
