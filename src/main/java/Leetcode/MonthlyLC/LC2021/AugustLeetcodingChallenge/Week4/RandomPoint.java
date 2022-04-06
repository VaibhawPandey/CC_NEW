package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week4;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomPoint {

    int arr[][];
    TreeMap<Integer, Integer> map;
    int sum = 0;
    Random random;

    public void Solution(int[][] rects) {

        arr = rects;
        map = new TreeMap<Integer, Integer>();
        random = new Random();

        for (int i = 0; i < rects.length; i++) {
            int rect[] = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }

    }

    public int[] pick() {

        int c = map.ceilingKey(random.nextInt(sum) + 1);

        return getPoint(arr[map.get(c)]);
    }

    private int[] getPoint(int[] point) {

        return new int[]{ point[0] + random.nextInt(point[2] - point[0] + 1), point[1] + random.nextInt(point[3] - point[1] + 1) };
    }
}
