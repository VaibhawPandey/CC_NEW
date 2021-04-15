package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];


        while (i < intervals.length && intervals[i][1] < start) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start,end});

        while (i < intervals.length) result.add(intervals[i++]);
        return result.stream().toArray(int[][]::new);

//        List<List<Integer>> res = new ArrayList<>();
//
//        boolean isVisited = false;
//
//        for (int i = 0; i < intervals.length; i++) {
//            if (!isVisited && intervals[i][0] > newInterval[0] && intervals[i][0] > newInterval[1]) {
//                isVisited = true;
//                res.add(Arrays.stream(newInterval).boxed().collect(Collectors.toList()));
//            }
//            if ((intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]) || (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1])) {
//                int start = i;
//                while (i + 1 < intervals.length && intervals[i + 1][0] <= newInterval[1]) {
//                    i++;
//                }
//                int num = Math.max(intervals[i][1], newInterval[1]);
//                int first = Math.min(intervals[start][0], newInterval[0]);
//                List<Integer> arrList = new ArrayList<>();
//                arrList.add(first);
//                arrList.add(num);
//                res.add(arrList);
//                isVisited = true;
//            } else
//                res.add(Arrays.stream(intervals[i]).boxed().collect(Collectors.toList()));
//        }
//
//        if (!isVisited) {
//            res.add(Arrays.stream(newInterval).boxed().collect(Collectors.toList()));
//        }
//
//        return res.stream().map(list -> list.stream().mapToInt(i -> i).toArray())
//                .toArray(int[][]::new);
    }
}
