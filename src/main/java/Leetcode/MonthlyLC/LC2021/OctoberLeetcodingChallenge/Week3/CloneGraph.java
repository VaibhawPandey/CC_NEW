package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week3;

import java.util.*;

public class CloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null)
            return node;

        Queue<Node> queue = new ArrayDeque<>();
        HashMap<Node, Node> hashMap= new HashMap<>();

        queue.add(node);
        hashMap.put(node, new Node(node.val));

        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            Node nodeS = hashMap.get(tempNode);

            if (tempNode.neighbors != null) {
                for (Node neighbor: tempNode.neighbors) {

                    Node nodeN = hashMap.get(neighbor);
                    if (nodeN == null) {
                        nodeN = new Node(neighbor.val);
                        queue.add(neighbor);
                        hashMap.put(neighbor, nodeN);
                    }
                    nodeS.neighbors.add(nodeN);
                }
            } }

        return hashMap.get(node);
    }
}
