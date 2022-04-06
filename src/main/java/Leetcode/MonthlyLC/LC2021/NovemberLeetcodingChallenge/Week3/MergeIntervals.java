package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        new MergeIntervals().merge(new int[][]{{1,3},{8,10},{2,6},{15,18}});
    }
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0)
            return new int[][]{{}};

        List<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return 0;
                else if (o1[0] > o2[0])
                    return 1;
                else
                    return -1;
            }
        });

        int low = intervals[0][0];
        int high = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
           if (intervals[i][0] > high) {
               arr.add(new int[]{low, high});
               low = intervals[i][0];
               high = intervals[i][1];
           } else
               high = Math.max(high, intervals[i][1]);
        }

        arr.add(new int[]{low, high});

        int res[][] = new int[arr.size()][2];
        arr.toArray(res);

        return res;
    }
}
