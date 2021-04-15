package main.java.Leetcode.WeeklyContest.WC210;

import java.util.*;

public class MaximalNetworkDepth {
    public static void main(String[] args) {
        new MaximalNetworkDepth().maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}});
    }
    public int maximalNetworkRank(int n, int[][] roads) {

        List<Integer> cityList[] = new List[n];
        for (int i = 0; i < n; i++)
            cityList[i] = new ArrayList<Integer>();


        for (int i = 0; i < roads.length; i++) {
            cityList[roads[i][0]].add(roads[i][1]);
            cityList[roads[i][1]].add(roads[i][0]);
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int count = cityList[i].size() + cityList[j].size();
                if (cityList[j].contains(i)) count--;

                maxCount = Math.max(maxCount, count);
            }
        }


        return maxCount;
    }
}
