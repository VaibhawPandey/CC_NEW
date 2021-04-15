package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week1;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        new RemoveCoveredIntervals().removeCoveredIntervals(new int[][]{{34335,39239},{15875,91969},{29673,66453},{53548,69161},{40618,93111}});
    }
    public int removeCoveredIntervals(int[][] intervals) {

        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) ->
            a[0] != b[0] ? a[0] - b[0]: a[1] - b[1]);

        int res = 0;
        int right = 0;
        for (int interval[]: intervals) {
            if (interval[1] > right){
                res++;
                right = interval[1];
            }
        }

        return res;
    }
}
