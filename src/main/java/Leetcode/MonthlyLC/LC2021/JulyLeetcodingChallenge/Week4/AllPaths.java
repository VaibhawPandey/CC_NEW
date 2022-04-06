package main.java.Leetcode.MonthlyLC.LC2021.JulyLeetcodingChallenge.Week4;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

    List<List<Integer>> out;
    // boolean visited[];

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int dest = graph.length - 1;
        if (dest < 0)
            return new ArrayList<>();

        out = new ArrayList<>();
        // visited = new boolean[dest + 1];
        List<Integer> res = new ArrayList<>();
        res.add(0);
        // visited[0] = true;

        allPaths(graph, 0, dest, res);

        return out;
    }

    private void allPaths(int[][] graph, int src, int dest, List<Integer> res) {

        if (src == dest) {
            out.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < graph[src].length; i++) {
            // if (!visited[graph[src][i]]) {
                // visited[graph[src][i]] = true;
                res.add(graph[src][i]);
                allPaths(graph, graph[src][i], dest, res);
                res.remove(res.size() - 1);
                // visited[graph[src][i]] = false;
            // }
        }

    }
}
