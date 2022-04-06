package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        if (n <= 0)
            return res;

        if (n <= 2) {
            for (int i = 0; i < n; i++)
                res.add(i);

            return res;
        }

        int degree[] = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;

            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                queue.add(i);
        }

        while (n > 2){
            int size = queue.size();
            n -= size;

            while (size-- > 0) {
                int val = queue.poll();
                for (int adj: adjList.get(val)) {
                    degree[adj]--;
                    if (degree[adj] == 1)
                        queue.add(adj);
                }
            }
        }

        while (!queue.isEmpty())
            res.add(queue.poll());

        return res;
    }
}
