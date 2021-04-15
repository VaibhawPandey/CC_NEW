package main.java.Leetcode.WeeklyContest.WC213;

import java.util.PriorityQueue;

public class FurtherBuilding {
    public static void main(String[] args) {
        new FurtherBuilding().furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2);
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int index = 1;
        for (index = 1; index < heights.length; index++) {
            if (heights[index-1] >= heights[index])
                continue;

            int diff = heights[index] - heights[index-1];

            if (diff <= bricks) {
               priorityQueue.add(diff);
               bricks -= diff;
            } else if (ladders > 0){
                int top = priorityQueue.isEmpty() ? 0 :priorityQueue.peek();
                if (diff < top) {
                    bricks += priorityQueue.poll();
                    priorityQueue.add(diff);
                    bricks -= diff;
                }
                ladders--;
            } else
                break;
        }

        return index;
    }

//    int res = 0;
//    int dp[][];
//    public int furthestBuilding(int[] heights, int bricks, int ladders) {
//
//        dp = new int[bricks + 1][ladders + 1];
//
//        solve(heights, bricks, ladders, 0);
//
//        return res;
//    }
//
//    private void solve(int[] heights, int bricks, int ladders, int index) {
//        res = Math.max(index, res);
//        if (index >= heights.length - 1) {
//            return;
//        }
//
//        while ((index < heights.length - 1) && heights[index] >= heights[index + 1])
//            index++;
//
//        res = Math.max(index, res);
//        if (index >= heights.length)
//            return;
//
//        int temp = heights[index + 1] - heights[index];
//        if (bricks >= temp && dp[bricks-temp][ladders] == 0) {
//            solve(heights, bricks - temp, ladders, index + 1);
//        }
//        if (ladders > 0 && dp[bricks][ladders] == 0) solve(heights, bricks, ladders - 1, index + 1);
//
//        dp[bricks][ladders] = res;
//    }
}
