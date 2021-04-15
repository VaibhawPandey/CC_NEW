package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week1;

import java.util.HashMap;
import java.util.Map;

public class PopulateNextRight {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    Map<Integer, Node> map;
    public Node connect(Node root) {

        if (root == null)
            return root;

        map = new HashMap<>();
        solve(root, 0);

        return root;
    }

    private void solve(Node root, int level) {

        Node lastNode = map.getOrDefault(level, null);
        if (lastNode != null)
            lastNode.next = root;
        map.put(level, root);

        if (root.left != null) solve(root.left, level + 1);
        if (root.right != null) solve(root.right, level + 1);
    }
}
