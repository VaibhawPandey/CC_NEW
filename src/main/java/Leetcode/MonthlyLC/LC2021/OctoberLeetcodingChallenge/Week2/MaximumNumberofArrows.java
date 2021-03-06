package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week2;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberofArrows {
    public static void main(String[] args) {
        new MaximumNumberofArrows().findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
    }
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1: -1;
            }
        });

        int res = 1, end = points[0][1];

        for (int i = 1; i < points.length; i++) {
           if (points[i][0] > end) {
               res++;
               end = points[i][1];
           }
        }

        return res;
    }
}
