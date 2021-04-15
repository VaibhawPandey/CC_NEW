package main.java.Leetcode.WeeklyContest.WC206;


public class MinCost {
    public int minCostConnectPoints(int[][] points) {

        int costSum = 0;
        for (int i = 1; i < points.length; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                int tempCost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                cost = Math.min(cost, tempCost);
            }
            costSum += cost;
        }

        return costSum;
    }
}
