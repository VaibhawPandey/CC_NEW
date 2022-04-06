package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottenOrange {

    public static void main(String[] args) {

        System.out.println(new RottenOrange().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {

        int loop_minute = 0;
        Queue queueList[] = new Queue[2];
        queueList[0] = new ArrayDeque();
        queueList[1] = new ArrayDeque();
        int noOfFreshOrangeCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1)
                    noOfFreshOrangeCount++;
                else
                  if (grid[i][j] == 2) {
                      queueList[0].add(new Pair(i, j));
                      // visited[i][j] = true;
                  }
            }
        }

        if (noOfFreshOrangeCount == 0)
            return loop_minute;

        int direction[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queueList[loop_minute % 2].isEmpty()) {

            Pair temp = (Pair) queueList[loop_minute % 2].poll();
            for (int i = 0; i < direction.length; i++) {
                int p = temp.x + direction[i][0], q = temp.y + direction[i][1];
                if (isValid(p, q, grid.length, grid[0].length) && grid[p][q] == 1) {
                    grid[p][q] = 2;
                    queueList[(loop_minute + 1) % 2].add(new Pair(p, q));
                    noOfFreshOrangeCount--;
                }
            }

            if (queueList[loop_minute % 2].isEmpty())
                loop_minute++;
        }

        if (noOfFreshOrangeCount > 0)
            return -1;

        return loop_minute - 1;
    }

    private boolean isValid(int p, int q, int m, int n) {
        if (p < 0 || p >= m || q < 0 || q >= n)
            return false;

        return true;
    }
}
